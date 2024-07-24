terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "5.50.0"
    }
  }
}

provider "aws" {
  region = "us-east-1"
  default_tags {
    tags = {
      application_name = "unity_novus"
      project_name     = "Project X"
      department      = "DevOps"
      owner           = "Raghavender_Reddy"
    }
  }
}