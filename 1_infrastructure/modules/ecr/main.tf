# creates ecr 
resource "aws_ecr_repository" "unity_repo" {
  name                 = var.ecr_repo_name
  image_tag_mutability = "MUTABLE"
}

