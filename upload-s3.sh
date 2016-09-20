# Uploads to bucket called "testapp-global" manually
# -- Requires s3cmd; sudo apt-get install s3cmd on Ubuntu at least, and then s3cmd --configure

s3cmd put -r target/SimpleEC2App-0.0.1-SNAPSHOT/resources/content/ s3://testapp-global/content/ --acl-public
