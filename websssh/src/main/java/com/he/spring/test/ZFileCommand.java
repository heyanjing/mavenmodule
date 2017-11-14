package com.he.spring.test;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by heyanjing on 2017/11/9 16:40.
 */
public class ZFileCommand extends HttpServlet {
    private static final long serialVersionUID = -2720014423604662780L;
    // 1.文件上传路径
    private static final String UPLOAD_DIRECTORY = "D:/文件上传";
    // 2.设置临时存储文件大小，当超过大小时，将先存储超出大小文件在临时目录
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 30;
    // 3.设置最大文件上传值
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 2000;
    // 4.最大请求值
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 2048;

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取文件名
        String filename=request.getParameter("name");
        //防止读取name名乱码
        filename=new String(filename.getBytes("iso-8859-1"),"utf-8");
        //在控制台打印文件名
        System.out.println("文件名："+filename);
        //设置文件MIME类型
        response.setContentType(getServletContext().getMimeType(filename));
        //设置Content-Disposition
        String realName = filename.substring(filename.indexOf("_")+1);
        response.setHeader("Content-Disposition", "attachment;filename="+realName);

        //输入流为项目文件，输出流指向浏览器
        InputStream is=new FileInputStream(UPLOAD_DIRECTORY+filename);
        ServletOutputStream os =response.getOutputStream();
		    /*
		     * 设置缓冲区
		     * is.read(b)当文件读完时返回-1
		     */
        int len=-1;
        byte[] b=new byte[1024];
        while((len=is.read(b))!=-1){
            os.write(b,0,len);
        }
        //关闭流
        is.close();
        os.close();

    }

    /**
     * @摘要 提供文件上传的方法
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        //1.设置字符编码为utf-8
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 2.检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 2.1如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return  ;
        }
        // 3.配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //4. 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 5.设置临时存储目录 java.io.tmpdir默认的临时文件路径为服务器的temp目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // 6.设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // 7.设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        //8. 如果目录不存在则创建
        File uploadDir = new File(UPLOAD_DIRECTORY);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        String fileMd5 = null;
        String chunk = null;
        try {
            // 10.解析请求的内容提取文件数据
            List<FileItem> formItems = upload.parseRequest(request);
            // 10.1迭代表单数据
            if (formItems != null && formItems.size() > 0) {
                for (FileItem item : formItems) {
                    if (item.isFormField()) {
                        String fieldName = item.getFieldName();
                        if(fieldName.equals("fileMd5")){
                            fileMd5 = item.getString("utf-8");
                        }
                        if(fieldName.equals("chunk")){
                            chunk = item.getString("utf-8");
                        }

                    }else{
                        String nFileName = new File(item.getName()).getName();

                        File file = new File(UPLOAD_DIRECTORY+"/"+fileMd5);

                        if(!file.exists()){
                            file.mkdir();
                        }
                        nFileName=nFileName.substring(0,nFileName.lastIndexOf("."))	;

                        item.write(new File(UPLOAD_DIRECTORY+"/"+fileMd5+"/"+chunk));

                        item.delete();
                    }

                }
            }
        } catch (Exception ex) {
            PrintWriter writer=response.getWriter();
            writer.print("error");
        }
    }
}