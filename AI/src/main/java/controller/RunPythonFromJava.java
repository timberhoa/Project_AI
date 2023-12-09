import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunPythonFromJava {
    public static void main(String[] args) {
        try {
            // Đường dẫn đến script Python
            String pythonScriptPath = "knn_number.py";

            // Tạo một quy trình để thực thi lệnh Python
            ProcessBuilder processBuilder = new ProcessBuilder("python", pythonScriptPath);

            // Thực thi lệnh
            Process process = processBuilder.start();

            // Đọc đầu ra từ quá trình Python
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Kiểm tra xem quá trình đã kết thúc chưa
            int exitCode = process.waitFor();
            System.out.println("Exit Code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
