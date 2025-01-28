# Digital_change_Management_sytem
DCMS manages coin change from transactions, credits points to customer accounts, integrates vendors, and stores statements in AWS S3. Built on Spring Boot, it ensures security with JWT and SSE, offering a user-friendly interface for customers to view accounts, redeem points, or transfer balances.


# Digital Change Management System (DCMS)

The **Digital Change Management System (DCMS)** is a robust solution for managing coin change from transactions at Convenience Stores . It credits leftover change as points to customer accounts, offering seamless redemption and tracking functionalities.

## Key Features
- **Customer Account Management**: Assigns unique 6-digit account IDs to customers for tracking points.
- **Change-to-Points Conversion**: Automates the process of converting leftover coin change into account points.
- **Vendor Integration**: Supports multiple vendors with unique IDs for transaction tracking.
- **Monthly Statements**: Generates vendor statements, stores them in AWS S3, and sends notifications.
- **Secure Receipt Storage**: Stores customer receipts in AWS S3 with pre-signed URLs and server-side encryption.
- **Customer Portal**: Allows customers to view accounts, redeem points, and transfer balances.

- # DCMS Services
A Digital Change Management System comprising the following microservices:
- **ServiceRegistry**: Handles service discovery.
- **ApiGateway**: Manages API routing and security.
- **UserService**: Manages user data.
- **VendorService**: Tracks vendor information.
- **TransactionService**: Handles transactions and point redemption.

## Tech Stack
- **Backend**: Java Spring Boot
- **Frontend**: Web/Mobile Interface
- **Database**: AWS RDS (MySQL/PostgreSQL)
- **Cloud Services**: AWS S3, SNS, Lambda
- **Security**: JWT Authentication, Server-Side Encryption (SSE)

## Architecture
- **Microservices**: Modular design for transactions, vendors, users, and redemption.
- **API Gateway**: Centralized communication with circuit breaker and fallback methods.
- **Deployment**: Hosted on AWS EC2 with CI/CD pipelines for automated builds and deployments.

## Getting Started
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/dcms.git



## Future Enhancements
AI-driven analytics for transaction trends.
Integration with loyalty programs and third-party services.


## Contact
For questions or contributions, reach out to:

**Name**: Jawad Mohammed

**Email**: jawatech8080@gmail.com

**LinkedIn**: [Jawad Mohammed](https://www.linkedin.com/in/jawad-mohammed-83a256196/)


## Contributions, issues, and feature requests are welcome! Feel free to fork this repository and improve DCMS.
You can customize the details like repository name, URLs, and contact info as needed. Let me know if you’d like further tweaks!   

