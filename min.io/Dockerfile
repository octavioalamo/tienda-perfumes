FROM minio/mc

COPY ./images /images
COPY ./init_bucket.sh /init_scripts/init_bucket.sh 
COPY ./wait-for-it.sh /init_scripts/wait-for-it.sh

ENTRYPOINT [ "/init_scripts/init_bucket.sh" ]
