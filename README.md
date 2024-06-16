# Introduction

**War Deployment README**

Welcome to the War Deployment repository! This repository contains the necessary resources and instructions for deploying the WAR (Web Application Archive) files to various environments.

### Deployment Process Overview

1. **WAR File Structure**: The WAR file consists of JSP, JS, JAR, and other necessary files for the web application.
   
2. **Initial Setup**: The WAR file has been unzipped, a folder has been created, and all its contents have been uploaded to this Git repository.

3. **Development Workflow**: Developers will make changes to the files within the WAR and push their changes to the `dev` branch.

4. **Branches**: There are two main branches:
   - `main`: Represents the production-ready code.
   - `dev`: Where developers push their changes for review.

5. **Code Review**: Changes pushed to the `dev` branch undergo review by an administrator. Upon successful review, the changes are merged into the `main` branch.

6. **WAR Creation and UAT Deployment**: After each merge to `main`, a new WAR file needs to be created. This WAR file will be deployed to the UAT (User Acceptance Testing) server for testing.

7. **Production Deployment**: Once the changes pass all testing in the UAT environment, the WAR file should be deployed to the production server.



Thank you for following the deployment process! If you have any questions or encounter any issues, feel free to reach out.