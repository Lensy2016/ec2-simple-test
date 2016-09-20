# Uploads to bucket called "testapp-global"

s3cmd put -r /home/limpygnome/git-remote/ec2-simple-test/target/SimpleEC2App-0.0.1-SNAPSHOT/resources/content/ s3://testapp-global/content/ --acl-public

