package cn.wb.learning.web.upAndLoadFile;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.web.upAndLoadFile
 * @email wubin326@qq.com
 * @date 2018/08/13
 */
@RestController
public class FileController {
    public static final Log log = LogFactory.getLog(FileController.class);

    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return "文件为空";
            }
            String fileName = file.getOriginalFilename();
            log.info("上传文件名为：" + fileName);
            String sufixName = fileName.substring(fileName.lastIndexOf(".") + 1);
            log.info("文件后缀" + sufixName);
            String filePath = "/Users/wufan/DeskTop/";
            String path = filePath + fileName;
            File dest = new File(path);
            //判断文件路径是否存在，不存在则新建
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdir();
            }
            file.transferTo(dest);//写入文件
            return "上传成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    @PostMapping("/batch")
    public String batch(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); i++) {
            file = files.get(i);
            String filePath = "/Users/wufan/DeskTop/";
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(new File(filePath + file.getOriginalFilename())));
                    stream.write(bytes);
                } catch (Exception e) {
                    stream = null;
                    return "第" + i + "个文件上传失败 ===> " + e.getMessage();
                } finally {
                    try {
                        stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                return "第" + i + "个文件上传失败 ===> 文件为空";
            }
        }
        return "上传成功";
    }

    @GetMapping("download")
    public String download(HttpServletRequest request, HttpServletResponse response) {
        String fileName = "new.txt";
        if (fileName != null) {
            File file = new File("/Users/wufan/Desktop/test/new.txt");
            if (file.exists()) {
                // 设置强制下载不打开
                response.setContentType("application/force-download");
                // 设置文件名
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);

                byte[] bytes = new byte[1024];
                FileInputStream fileInputStream = null;
                BufferedInputStream bufferedInputStream = null;
                try{
                    //从本地读取文件到输入流
                    fileInputStream = new FileInputStream(file);
                    //将输入流转换为可缓存的输入流
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                    //输出流
                    OutputStream outputStream = response.getOutputStream();
                    //将文件读入到字节数组
                    int read = bufferedInputStream.read(bytes);
                    while (read!=-1){
                        //输出文件
                        outputStream.write(bytes,0,read);
                        read = bufferedInputStream.read(bytes);
                    }
                    return "下载成功";
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if (fileInputStream != null){
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (bufferedInputStream!=null){
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return "下载失败";
    }
}
