# CI/CD Pipeline with Jenkins, Docker, Maven, and Argo CD

This repository demonstrates how to set up an end-to-end CI/CD pipeline for Java Spring Boot microservices using Jenkins, Docker, SonarQube, Kubernetes, and Argo CD. A custom Docker image is used as the Jenkins agent, containing all necessary tools like Java, Maven, Docker, and Git.

## Docker Image

I’ve built a Docker image pre-configured with **Java**, **Maven**, **Docker**, and **Git** to simplify the pipeline setup. The image is available on Docker Hub.

- **Docker Hub Link**: [sai_anil_tekuri/ci-agent](https://hub.docker.com/repository/docker/saianilt/custom-jenkins-agent-root-with-git/general)
- **Image Name**: `saianilt/custom-jenkins-agent-root-with-git`

You can use this image in your Jenkins pipeline to automate Java Spring Boot builds, tests, and deployments.

## How to Use the Docker Image

To use this Docker image as the agent in your Jenkins pipeline, add the following configuration to your `Jenkinsfile`:

```groovy
pipeline {
  agent {
    docker {
      image 'saianilt/custom-jenkins-agent-root-with-git:latest'
      args '--user root -v /var/run/docker.sock:/var/run/docker.sock'
    }
  }
  stages {
    stage('Checkout') {
      steps {
        ........
      }
    }
  }
}
```

## Prerequisites

To run this pipeline successfully, ensure you have the following set up:

- **Jenkins** (with Docker and Pipeline plugins)
- **Kubernetes** (with Minikube for local testing)
- **Argo CD** (for continuous deployment)
- **SonarQube** (for static code analysis)

## Pipeline Stages

This pipeline automates the entire software lifecycle:

1. **Checkout Code**: Pull the source code from a Git repository.
2. **Build with Maven**: Compile and package the Spring Boot application.
3. **Run Tests**: Execute unit tests using JUnit and Mockito.
4. **SonarQube Analysis**: Perform static code analysis to ensure code quality.
5. **Build Docker Image**: Create a Docker image of the Spring Boot application.
6. **Deploy to Kubernetes**: Use Argo CD to deploy the application to a Kubernetes cluster.

## How to Run Locally

1. **Clone the Repository**:

    ```bash
    git clone https://github.com/SaiAnilTekuri/DevOps-CICD-Workflow.git
    ```

2. **Set Up Jenkins**:
   - Install Jenkins on your local machine or EC2 instance.
   - Ensure you have Docker installed on the Jenkins machine.

3. **Use the Provided Docker Image**:
   - Specify the Docker image `saianilt/custom-jenkins-agent-root-with-git` in your Jenkins pipeline.

4. **Run the Pipeline**:
   - Once everything is set up, run the pipeline from the Jenkins dashboard.

For detailed steps on setting up Jenkins, SonarQube, Docker, and Kubernetes, refer to the Medium blog post: [Automating CI/CD for Java Spring Boot Applications](https://medium.com/@saianiltekuri98/66a4ea6d216a).
