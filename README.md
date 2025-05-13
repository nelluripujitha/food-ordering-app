# 🍽️ Food Ordering App

A cloud-ready, full-stack **Food Ordering App** developed with **Java Spring Boot**, modern frontend technologies, and deployed using **AWS Cloud Services**.

This application is structured using **microservices** and demonstrates real-world capabilities such as user management, menu browsing, ordering, and cloud-native deployment.

---

## 🚀 Features

- 🔐 Secure User Authentication
- 🏪 Restaurant Browsing & Menu Management
- 🛒 Add to Cart & Place Orders
- 📦 Track Order Status
- 🌐 Microservices with Eureka Discovery
- ☁️ Cloud Deployment via AWS (EC2, EKS, RDS)

---

## 🧱 Microservices Architecture

- **User Service** – User registration, login
- **Restaurant Service** – Restaurant management
- **Food Service** – Menu management
- **Order Service** – Order placement & tracking
- **Eureka Server** – Service registry
- **Frontend** – UI for user interaction (/Angular-based)
- **Deployments** – AWS Infrastructure-as-Code 

---

## 🛠️ Tech Stack

| Layer          | Technology                                  |
|----------------|---------------------------------------------|
| Backend        | Java, Spring Boot, Spring Data JPA          |
| Frontend       | HTML/CSS/TypeScript/Angular                 |
| Database       | **PostgreSQL on Amazon RDS** , MongoDB      |
| Object Storage | **Amazon S3** for images & assets           |
| Deployment     | **EC2**, **EKS**, **RDS**                   |             
| Container      | Docker                                      |
| CI/CD          | Jenkins                                     |
| Code Coverage  | SonarQube                                   |

---

## ☁️ AWS Deployments

The `Deployments/` folder contains:

- 🐳 **Dockerfiles**: Containerization setup for microservices
- 🚀 **EC2/EKS Setup**: Scripts for provisioning and deploying to EC2 or EKS
- 🔄 **RDS Configuration**: DB schema init and connectivity
- 🧾 **IAM Policies & Roles**: Least-privilege access to EKS, RDS, and EC2

Make sure you:

1. Configure your AWS CLI with `aws configure`
2. Set IAM permissions for S3, EC2, and RDS access
3. Use provided scripts or Terraform templates to deploy infrastructure
4. Use environment variables to inject AWS secrets securely

---
## 📝 Future Enhancements

✅ JWT-based authentication

✅ Upload profile/menu images to S3

✅ Integrate AWS SES for email notifications

📦 Payment gateway integration

🧪 Add full test coverage


## 🛠️ Setup Guide

### Prerequisites

- Java 17+
- Node.js & npm
- Docker & Docker Compose
- AWS CLI configured
- Maven



### Clone the Repository

```bash
git clone https://github.com/nelluripujitha/food-ordering-app.git
cd food-ordering-app

---


## 📬 Contact

**Mani Pujitha Nelluri**  
📧 pujitha2111@gmail.com  
🔗 [GitHub](https://github.com/nelluripujitha)  
🔗 




