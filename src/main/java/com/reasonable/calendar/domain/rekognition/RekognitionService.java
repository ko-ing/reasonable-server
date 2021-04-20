package com.reasonable.calendar.domain.rekognition;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClient;
import com.amazonaws.services.rekognition.model.*;
import com.reasonable.calendar.util.JsonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RekognitionService {
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Value("${cloud.aws.credentials.accessKey}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secretKey}")
    private String secretKey;

    public String detectLabels(String photoName) {
        BasicAWSCredentials creds = new BasicAWSCredentials(accessKey, secretKey);

        AmazonRekognition rekognitionClient = AmazonRekognitionClient.builder()
            .withRegion(region)
            .withCredentials(new AWSStaticCredentialsProvider(creds))
            .build();

        DetectFacesRequest request = new DetectFacesRequest()
            .withImage(new Image()
                .withS3Object(new S3Object()
                    .withName(photoName)
                    .withBucket(bucket)))
            .withAttributes(Attribute.ALL);
        DetectFacesResult result = rekognitionClient.detectFaces(request);

        return JsonUtil.write(result);
    }
}