# terraform {
#   backend "s3" {
#     bucket         = "<s3_bucket_name>"
#     key            = "terraform.tfstate"
#     region         = "<region>"
#     dynamodb_table = "<dynamo_db_table_name>"
#   }
# }