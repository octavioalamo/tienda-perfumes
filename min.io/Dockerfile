FROM minio/mc:RELEASE.2023-10-24T21-42-22Z

COPY ./images /images
COPY ./init_bucket.sh ./wait-for-it.sh /init_scripts/
RUN chmod +x /init_scripts/*

ENTRYPOINT [ "/init_scripts/init_bucket.sh" ]
