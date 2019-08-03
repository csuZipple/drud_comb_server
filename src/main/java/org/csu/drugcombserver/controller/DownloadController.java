package org.csu.drugcombserver.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.csu.drugcombserver.core.BaseController;
import org.springframework.core.io.ResourceLoader;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@Validated
@RequestMapping("/download")
public class DownloadController extends BaseController {
    @Resource
    private ResourceLoader resourceLoader;
    private final static String[] FILE_NAMES = {"combination_bliss.csv",
            "integration.csv",
            "cell_line.csv",
            "drug_chemical_info.csv",
            "9606.protein_chemical.links.detailed.v5.0.tsv",
            "9606.protein.links.v11.0.txt"};

    @RequestMapping("/{index}")
    public void getDrugProteinLinks(HttpServletRequest request, HttpServletResponse response,@PathVariable("index") Integer index){
        String fileName = FILE_NAMES[index];
        InputStream inputStream = null;
        ServletOutputStream servletOutputStream = null;
        try {
            String path = "source" + File.separator + fileName;
            org.springframework.core.io.Resource resource = resourceLoader.getResource("classpath:"+path);
            response.setContentType("application/octet-stream;charset=UTF-8");
//            response.setCharacterEncoding("UTF-8"); // 设置文件流编码格式 不然中文会乱码
            response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.addHeader("Pragma", "no-cache");

            inputStream = resource.getInputStream();
            servletOutputStream = response.getOutputStream();
            IOUtils.copy(inputStream, servletOutputStream);
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (servletOutputStream != null) {
                    servletOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                System.gc();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
