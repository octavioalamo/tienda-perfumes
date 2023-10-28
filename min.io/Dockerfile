FROM minio/mc

COPY ./images /images
COPY ./init_bucket.sh ./wait-for-it.sh /init_scripts/
RUN chmod +x /init_scripts/*

ENTRYPOINT [ "/init_scripts/init_bucket.sh" ]
