package br.com.agendabelem.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

/*
 * 
 * @author andre
 */
@Path("/file")
public class FileService {
    
    @Context
    private HttpServletRequest request;
    
    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_HTML)
    public Response uploadFile(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) throws IOException {

            String uploadedFileLocation = "/home/andre/NetBeansProjects/AgendaBelem/src/main/webapp/uploads/" + fileDetail.getFileName();
//            InputStream uploadedInputStream = request.getInputStream();
            
            // save it
            writeToFile(uploadedInputStream, uploadedFileLocation);
            
            String output = "uploads/" + fileDetail.getFileName();
//            String output = "<img src='" + src + "' width='150' height='150' />";

            return Response.status(200).entity(output).build();
    }

    // save uploaded file to new location
    private void writeToFile(InputStream uploadedInputStream,
            String uploadedFileLocation) {

            try {
                    OutputStream out = new FileOutputStream(new File(
                                    uploadedFileLocation));
                    int read = 0;
                    byte[] bytes = new byte[1024];

                    out = new FileOutputStream(new File(uploadedFileLocation));
                    while ((read = uploadedInputStream.read(bytes)) != -1) {
                            out.write(bytes, 0, read);
                    }
                    out.flush();
                    out.close();
            } catch (IOException e) {

                    e.printStackTrace();
            }

    }
}
