module "vpc" {
  source = "./modules/vpc"
}

module "eks_cluster" {
  source         = "./modules/eks"
  eks_cluster_name       = var.eks_cluster_name
  subnet_ids     = module.vpc.public_subnets
  instance_types = var.instance_types
}


module "ecr_repo" {
  source   = "./modules/ecr"
  ecr_repo_name = var.ecr_repo_name
}

