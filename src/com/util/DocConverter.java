package com.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.util.ResourceBundle;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

public class DocConverter {
	
	private static final int environment = 1;// ����1��windows,2:linux(�漰pdf2swf·������)
	private String fileString;
	private String outputPath = "";// ����·������������þ������Ĭ��λ��
	private String fileName;
	private File pdfFile;
	private File swfFile;
	private File docFile;

	public DocConverter(String fileString) {
		ini(fileString);
	}

	/*
	 * �������� file @param fileString
	 */
	public void setFile(String fileString) {
		ini(fileString);
	}

	

	/*
	 * ��ʼ�� @param fileString
	 */
	private void ini(String fileString) {
		this.fileString = fileString;
		fileName = fileString.substring(0, fileString.lastIndexOf("."));
		docFile = new File(fileString);
		pdfFile = new File(fileName + ".pdf");
		swfFile = new File(fileName.substring(0,fileName.lastIndexOf("\\"))+fileName.substring(fileName.lastIndexOf("\\"),fileName.lastIndexOf("\\")+15) + ".swf");
	}

	/*
	 * תΪPDF @param file
	 */
	private void doc2pdf() throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("OpenOfficeService");  
        String OpenOffice_HOME = rb.getString("OO_HOME");  
        String host_Str = rb.getString("oo_host");  
        String port_Str = rb.getString("oo_port");  
		if (docFile.exists()) {
			if (!pdfFile.exists()) {
				try {
					String command = OpenOffice_HOME  
		                    + "\\program\\soffice.exe -headless -accept=\"socket,host="  
		                    + host_Str + ",port=" + port_Str + ";urp;\" -nofirststartwizard";  
		            System.out.println("###\n" + command); 
		            Process pro = Runtime.getRuntime().exec(command); 
		            int port=Integer.parseInt(port_Str);
		            OpenOfficeConnection connection = new SocketOpenOfficeConnection(port);
					connection.connect();
					DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
					converter.convert(docFile, pdfFile);
					// close the connection
					connection.disconnect();
					System.out.println("****pdfת���ɹ���PDF�����" + pdfFile.getPath() + "****");
					pro.destroy();  
				} catch (java.net.ConnectException e) {
					// ToDo Auto-generated catch block
					e.printStackTrace();
					System.out.println("****swfת���쳣��openoffice����δ������****");
					throw e;
				} catch (com.artofsolving.jodconverter.openoffice.connection.OpenOfficeException e) {
					e.printStackTrace();
					System.out.println("****swfת�����쳣����ȡת���ļ�ʧ��****");
					throw e;
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
			} else {
				System.out.println("****�Ѿ�ת��Ϊpdf������Ҫ�ٽ���ת��****");
			}
		} else {
			System.out.println("****swfת�����쳣����Ҫת�����ĵ������ڣ��޷�ת��****");
		}
	}

	/*
	 * ת����swf
	 */
	private void pdf2swf(String p2spath) throws Exception {
		Runtime r = Runtime.getRuntime();
		if (!swfFile.exists()) {
			if (pdfFile.exists()) {
				if (environment == 1)// windows��������
				{
					try {
						// �������SWFTools��װ·����Ҫ������Ӧ����
						System.out.println(pdfFile.getPath());
						Process p = r.exec(p2spath+"/pdf2swf.exe " + pdfFile.getPath() + " -o " + swfFile.getPath() + "  -s flashversion=9 -T 9");
						System.out.print(loadStream(p.getInputStream()));
						System.err.print(loadStream(p.getErrorStream()));
						System.out.print(loadStream(p.getInputStream()));
						System.err.println("****swfת���ɹ����ļ������" + swfFile.getPath() + "****");
						if (pdfFile.exists() && !docFile.getName().endsWith("pdf")) {
							pdfFile.delete();
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					}
				} 
			} else {
				System.out.println("****pdf�����ڣ��޷�ת��****");
			}
		} else {
			System.out.println("****swf�Ѵ��ڲ���Ҫת��****");
		}
	}

	static String loadStream(InputStream in) throws IOException {
		int ptr = 0;
		//��InputStream�ֽ��� �滻ΪBufferedReader�ַ��� 2013-07-17�޸�
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder buffer = new StringBuilder();
		while ((ptr = reader.read()) != -1) {
			buffer.append((char) ptr);
		}
		return buffer.toString();
	}

	/*
	 * ת��������
	 */
	public boolean conver(String p2spath) {
		if (swfFile.exists()) {
			System.out.println("****swfת������ʼ���������ļ��Ѿ�ת��Ϊswf****");
			return true;
		}

		if (environment == 1) {
			System.out.println("****swfת������ʼ��������ǰ�������л���windows****");
		} 

		try {
			doc2pdf();
			pdf2swf(p2spath);
		} catch (Exception e) {
			// TODO: Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		if (swfFile.exists()) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * �����ļ�·�� @param s
	 */
	public String getswfPath() {
		if (swfFile.exists()) {
			String tempString = swfFile.getPath();
			tempString = tempString.replaceAll("\\\\", "/");
			return tempString;
		} else {
			return "";
		}
	}

	/*
	 * �������·��
	 */
	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
		if (!outputPath.equals("")) {
			String realName = fileName.substring(fileName.lastIndexOf("/"), fileName.lastIndexOf("."));
			if (outputPath.charAt(outputPath.length()) == '/') {
				swfFile = new File(outputPath + realName + ".swf");
			} else {
				swfFile = new File(outputPath + realName + ".swf");
			}
		}
	}

	public static void main(String s[]) {
		DocConverter d = new DocConverter("C:/Users/Flyaway/Desktop/����ѯ�����ݿƼ����޹�˾������.doc");
		d.conver("D:/JavaWeb/ructime/51pink/WebRoot");
	}
}
