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
	
	private static final int environment = 1;// 环境1：windows,2:linux(涉及pdf2swf路径问题)
	private String fileString;
	private String outputPath = "";// 输入路径，如果不设置就输出在默认位置
	private String fileName;
	private File pdfFile;
	private File swfFile;
	private File docFile;

	public DocConverter(String fileString) {
		ini(fileString);
	}

	/*
	 * 重新设置 file @param fileString
	 */
	public void setFile(String fileString) {
		ini(fileString);
	}

	

	/*
	 * 初始化 @param fileString
	 */
	private void ini(String fileString) {
		this.fileString = fileString;
		fileName = fileString.substring(0, fileString.lastIndexOf("."));
		docFile = new File(fileString);
		pdfFile = new File(fileName + ".pdf");
		swfFile = new File(fileName.substring(0,fileName.lastIndexOf("\\"))+fileName.substring(fileName.lastIndexOf("\\"),fileName.lastIndexOf("\\")+15) + ".swf");
	}

	/*
	 * 转为PDF @param file
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
					System.out.println("****pdf转换成功，PDF输出：" + pdfFile.getPath() + "****");
					pro.destroy();  
				} catch (java.net.ConnectException e) {
					// ToDo Auto-generated catch block
					e.printStackTrace();
					System.out.println("****swf转换异常，openoffice服务未启动！****");
					throw e;
				} catch (com.artofsolving.jodconverter.openoffice.connection.OpenOfficeException e) {
					e.printStackTrace();
					System.out.println("****swf转换器异常，读取转换文件失败****");
					throw e;
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
			} else {
				System.out.println("****已经转换为pdf，不需要再进行转化****");
			}
		} else {
			System.out.println("****swf转换器异常，需要转换的文档不存在，无法转换****");
		}
	}

	/*
	 * 转换成swf
	 */
	private void pdf2swf(String p2spath) throws Exception {
		Runtime r = Runtime.getRuntime();
		if (!swfFile.exists()) {
			if (pdfFile.exists()) {
				if (environment == 1)// windows环境处理
				{
					try {
						// 这里根据SWFTools安装路径需要进行相应更改
						System.out.println(pdfFile.getPath());
						Process p = r.exec(p2spath+"/pdf2swf.exe " + pdfFile.getPath() + " -o " + swfFile.getPath() + "  -s flashversion=9 -T 9");
						System.out.print(loadStream(p.getInputStream()));
						System.err.print(loadStream(p.getErrorStream()));
						System.out.print(loadStream(p.getInputStream()));
						System.err.println("****swf转换成功，文件输出：" + swfFile.getPath() + "****");
						if (pdfFile.exists() && !docFile.getName().endsWith("pdf")) {
							pdfFile.delete();
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					}
				} 
			} else {
				System.out.println("****pdf不存在，无法转换****");
			}
		} else {
			System.out.println("****swf已存在不需要转换****");
		}
	}

	static String loadStream(InputStream in) throws IOException {
		int ptr = 0;
		//把InputStream字节流 替换为BufferedReader字符流 2013-07-17修改
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder buffer = new StringBuilder();
		while ((ptr = reader.read()) != -1) {
			buffer.append((char) ptr);
		}
		return buffer.toString();
	}

	/*
	 * 转换主方法
	 */
	public boolean conver(String p2spath) {
		if (swfFile.exists()) {
			System.out.println("****swf转换器开始工作，该文件已经转换为swf****");
			return true;
		}

		if (environment == 1) {
			System.out.println("****swf转换器开始工作，当前设置运行环境windows****");
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
	 * 返回文件路径 @param s
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
	 * 设置输出路径
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
		DocConverter d = new DocConverter("C:/Users/Flyaway/Desktop/北京询达数据科技有限公司刘力超.doc");
		d.conver("D:/JavaWeb/ructime/51pink/WebRoot");
	}
}
