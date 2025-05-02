package com.michilatte.ecomarket.storage;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class GoogleCloudStorageService {

    private String bucketName = "ecommerce-backendmichi";

    //Local: private String keyPath = "C:\\Users\\arrue\\Documents\\GCP\\ecommerce-michi-key.json";

    private final Storage storage;

    public GoogleCloudStorageService() {
        this.storage = StorageOptions.getDefaultInstance().getService();
    }

        /*{
        try {
            storage = StorageOptions.newBuilder().setCredentials(ServiceAccountCredentials.fromStream(new FileInputStream(keyPath))).build().getService();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }*/

    public String uploadImage(MultipartFile imageFile) throws IOException {
        /*if (!imageFile.getContentType().startsWith("imagen/")) {
            throw new IllegalArgumentException("Solo se permiten archivos de imagen");
        }*/

        String extension = FilenameUtils.getExtension(imageFile.getOriginalFilename());
        String fileName = "productos/" + UUID.randomUUID() + "." + extension;

        //subir a google cloud storage
        BlobId blobId = BlobId.of(bucketName, fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(imageFile.getContentType()).build();
        storage.create(blobInfo, imageFile.getBytes());

        return String.format("https://storage.googleapis.com/%s/%s", bucketName, fileName);

    }

}
