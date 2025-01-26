# Software Requirements Specification (SRS)

## 1. Introduction

This document outlines the Software Requirements Specification (SRS) for the development of a purchasing and shipment management system. The system is designed to support purchasing via product links or product names and images, and it will manage shipments for users, administrators, and sellers. The software will leverage a robust technical stack to ensure high availability, scalability, and security.

## 2. Goal and Scope

The goal is to design a flexible, modular, and highly secure system that allows services to be turned on and off as needed. The software will support purchasing and shipment management, with features tailored to customers, sellers, and administrators. The system will integrate with third-party payment services for seamless transactions.

**Key Requirements:**
- High availability and scalability
- Integration with third-party payment services
- Modular services that can be turned on/off
- Secure and flexible management for users, sellers, and administrators

## 3. Technical Stack

- **Programming Language**: Java 8
- **Frameworks**: Spring Boot, Spring Cloud, Spring AI
- **Database**: PostgreSQL, Redis
- **Messaging & Streaming**: Kafka
- **Search Engine**: Elasticsearch
- **CI/CD**: GitHub Actions
- **Source Control**: GitHub
- **Cloud**: AWS Cloud
- **Payment Services**: Stripe, Google Pay, Apple Pay, PayPal

## 4. System Overview

The system will have three main user roles: Customer, Seller, and Administrator. Each role will have distinct features and capabilities. The system will be built using a microservice-based architecture, ensuring flexibility, scalability, and ease of maintenance.

**Modules/Services:**
- **User Management**: Account creation, login, and profile management
- **Order Management**: Product orders, payments, and shipment tracking
- **Product Management**: Product catalog management and associated data
- **Payment Management**: Handling payments via multiple methods and third-party integrations
- **Shipping Management**: Tracking and managing shipments
- **Notification Management**: Managing email, SMS, and app-based notifications
- **Analytics & Reporting**: Viewing revenue, user demographics, traffic analytics, etc.
- **Customer Support**: Providing assistance and support to customers
- **Inventory Management**: Managing stock levels and product availability
- **Marketing Management**: Creating and managing marketing campaigns

## 5. Customer Features

### 5.1 Account Registration (with Membership)
- Register a new account with personal details.
- Choose a membership package: Basic, Premium, or VIP.

### 5.2 Login
- Log in via email and password.
- Social login options: Google, Facebook, Twitter.
- Multi-factor Authentication (MFA) for premium accounts.

### 5.3 View Products
- Display a list of products.
- Filter products by category, price, brand.

### 5.4 Product Search
- Quick search by product name or brand.

### 5.5 Order Products
- Select quantity and add to the cart.
- Edit cart before checkout.

### 5.6 Checkout
- Supports multiple payment methods: Check, Zelle, Credit card, Bank account.
- Confirm order and send confirmation via email/notification.

### 5.7 Account Management
- Update personal information and password.
- Manage shipping addresses.

### 5.8 Coupon Management
- Apply discount codes at checkout.

### 5.9 View Purchase History
- View purchase history with payment and shipping status.

### 5.10 Order Management
- Track the status of orders (Processing, Delivered, Canceled).

### 5.11 Expense Management
- Summarize expenses for each transaction and product.

### 5.12 Order Tracking
- Provide detailed shipping status updates.

### 5.13 Notification Management
- Configure notifications via email, SMS, or app.

### 5.14 Payment Management
- Manage saved payment methods.

### 5.15 Product Review
- Users can rate and comment on products.

### 5.16 Messaging via Messenger/Zalo
- Send messages to customer service.

### 5.17 View Receipt
- View and download purchase receipts.

### 5.18 Review and Comment Management
- The system moderates reviews and ratings for products.

## 6. Seller Features

### 6.1 Account Registration
- Select service package: Pay-per-order, monthly, quarterly, or annual subscription.

### 6.2 Login
- Log in using the seller's account.

### 6.3 Identity Verification
- Verify using government-issued ID or third-party authentication.

### 6.4 Store Setup
- Configure store information, logo, and description.

### 6.5 Register Product Category
- Choose product types and related categories.

### 6.6 Product Creation
- Add products with descriptions, pricing, and images.
- Supports importing products via Excel files.

### 6.7 Account Management
- Update store details, password, and address.

### 6.8 Bank Account Management
- Update bank account information for payments.

### 6.9 View Payment History
- View payment history and service fees.

### 6.10 Revenue Management
- Track revenue by day, week, month, year.

### 6.11 Notification Management
- Configure notifications for sellers.

### 6.12 View Revenue Reports
- Reports for revenue by day, month, quarter, and year.

### 6.13 SEO Push Registration
- Enhance SEO for the seller’s store.

### 6.14 View Traffic Analytics
- View traffic stats for the store and product pages.

### 6.15 Demographics Stats
- View customer demographics such as age and location.

### 6.16 Reviews, Ratings, and Comments
- Manage customer reviews and comments (can choose to show/hide).

## 7. Administrator Features

### 7.1 Product Management
- Add, update, or delete products in the system.

### 7.2 View Revenue Statistics
- Aggregate revenue statistics for the entire system.

### 7.3 User Management
- Manage buyer and seller accounts.

### 7.4 Data Management
- Manage all data in the system.

### 7.5 View User Analytics
- Analyze registered users and website traffic.

### 7.6 Create Promotion Events
- Create promotional campaigns and discounts for buyers.

### 7.7 Create Notifications
- Create system-wide or user-specific notifications.

## 8. Security Requirements

- **Authentication and Authorization**: Use OAuth2 for secure login and JWT for user authorization.
- **Data Encryption**: Use SSL/TLS for data transmission. Encrypt sensitive data such as payment details.
- **Secure Payment Methods**: Integrate with Stripe, Google Pay, Apple Pay, and PayPal with secure APIs.
- **Access Control**: Restrict access to sensitive data and services based on user roles (Admin, Seller, Customer).
- **Data Backup**: Implement regular data backups and disaster recovery plans.

## 9. Performance Requirements

- **Scalability**: The system should handle large traffic spikes, especially during promotions or high seasons.
- **Availability**: 99.9% uptime, with failover mechanisms and automatic scaling.

## 10. System Integration and Dependencies

- Integration with third-party payment gateways (Stripe, Google Pay, Apple Pay, PayPal).
- Integration with external shipment tracking APIs.
- Integration with external analytics and reporting tools.

## 11. Non-Functional Requirements

- **Usability**: The user interface should be intuitive and responsive.
- **Reliability**: The system must be highly available, with minimal downtime.
- **Scalability**: The system should be able to handle increased load, especially during peak times.
- **Maintainability**: The system should be modular and easy to update, with a clear separation of concerns.

## 12. Functional Requirements

| Module/Service       | Feature               | Description                                                     |
|----------------------|-----------------------|-----------------------------------------------------------------|
| **User Management**   | Account Registration  | Allows users to register with personal details.                |
|                      | Login                 | Enables users to log in using email and password. Multi-factor authentication for premium accounts. |
| **Order Management**  | View Products         | Displays a list of products with filters for category, price, and brand. |
|                      | Product Search        | Quick search functionality by product name or brand.           |
|                      | Order Products        | Allows users to select quantity and add products to the cart.  |
|                      | Checkout              | Supports multiple payment methods and order confirmation with email/notification. |
| **Payment Management**| Manage Payment Methods| Users can manage saved payment methods.                        |
| **Shipping Management**| Order Tracking       | Provides detailed shipping status updates.                      |
| **Notification Management** | Configure Notifications | Allows users to configure notifications via email, SMS, or app. |
| **Product Management**| Product Creation      | Sellers can add products with descriptions, pricing, and images.|
| **Revenue Management**| Track Revenue         | Sellers can track revenue by day, week, month, year.           |
| **Analytics & Reporting**| View Revenue Reports | Provides revenue reports for different time periods.           |
| **Security Requirements** | Authentication and Authorization | Uses OAuth2 for secure login and JWT for user authorization. |
| **Performance Requirements** | Scalability | The system should handle large traffic spikes, especially during promotions or high seasons. |

## 13. Assumptions and Dependencies

**Assumptions:**
- Users will have access to the internet to use the system.
- Payment gateways will be available and operational.

**Dependencies:**
- Integration with third-party payment services.
- Use of AWS Cloud for hosting and deployment.

## 14. Interface Requirements

Detail the interfaces between the system and other systems,
