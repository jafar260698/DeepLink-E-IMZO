package uz.yt.sample.myapplication;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
        import java.io.IOException;

public class FileHelper {

    // Method to write a byte array to a file in Android
    public static void writeByteArrayToFile(Context context, String fileName, byte[] data) {
        FileOutputStream fos = null;

        try {
            // Open a file output stream
            File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

            // Create a file with the specified name in the Downloads directory
            File file = new File(downloadsDir, fileName);

            // Open a file output stream
            fos = new FileOutputStream(file);

            // Write the byte array to the file
            fos.write(data);

            // Optionally, you can close the stream to release resources
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Ensure the stream is closed in case of an exception
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

