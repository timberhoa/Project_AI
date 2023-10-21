package controller;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
/**
 * Servlet implementation class UploadServlet
 */
@MultipartConfig
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	//Vị trí của file sauu khi được upload
	private static final String UPLOAD_DIRECTORY = "D:\\JavaWeb\\Project_AI\\src\\main\\webapp\\File";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Tạo thư mục lưu trữ file tải lên nếu chưa tồn tại
        File uploadDir = new File(UPLOAD_DIRECTORY);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Lấy tệp tin được tải lên từ yêu cầu
        Part filePart = request.getPart("file");
        String fileName = getFileName(filePart);
        String filePath = UPLOAD_DIRECTORY + "\\" + fileName;
        filePart.write(filePath);

        //Xử lý file ....
        
        
        //Xét lại fileName và filetPath = thông tin của file sau khi xử lý để có thể tải về
        
        // Lưu đường dẫn ảnh đã tải lên vào thuộc tính session
        if(request.getSession().getAttribute("filePath") != null) {
        	request.getSession().removeAttribute("filePath");
        }
        if(request.getSession().getAttribute("fileName") != null) {
        	request.getSession().removeAttribute("fileName");
        }
        
        
        request.getSession().setAttribute("filePath", filePath);
        request.getSession().setAttribute("fileName", fileName);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        
        // Chuyển hướng trở lại trang upload.jsp
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
	 private String getFileName(Part part) {
	        String header = part.getHeader("content-disposition");
	        for (String headerPart : header.split(";")) {
	            if (headerPart.trim().startsWith("filename")) {
	                return headerPart.substring(headerPart.indexOf('=') + 1).trim()
	                        .replace("\"", "");
	            }
	        }
	        return null;
	    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
