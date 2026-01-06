
# Email Template Generator with AI

A **Spring Boot REST API** application that generates professional email templates dynamically using **OpenRouter's free LLM API**. Users can send JSON requests to generate emails with different purposes, recipients, and tones.

---

##  Features

- Generate professional emails dynamically
- Multiple tones supported: polite, formal, friendly, etc.
- Works entirely with free OpenRouter API
- Simple REST API integration (Postman)
- Tracks response time and timestamp for generated emails
- API key handled securely via environment variables

---

## Technology Stack

| Component           | Version / Details        |
|--------------------|-------------------------|
| Java               | 17+                     |
| Spring Boot        | 3.x                     |
| AI Model Provider  | OpenRouter (gpt-4o-mini) |
| HTTP Client        | Spring RestTemplate      |
| Testing            | Postman        |
| Build Tool         | Maven                   |

---

## Prerequisites

- Java 17+
- Maven
- Postman
- OpenRouter API Key (https://openrouter.ai/)

---

## Setup & Configuration

###  Clone the repository

```bash
git clone https://github.com/yourusername/EmailTemplateGenerator.git
cd EmailTemplateGenerator
```
### Set Environment variable 


```Permanent setup (Windows):
setx OPENROUTER_API_KEY "your_api_key_here"
```
Restart your IDE or terminal after setting the environment variable.

### Update application.properties


```
openrouter.api.key=${OPENROUTER_API_KEY}
server.port=8080
```
### Build and Run

```
mvn clean install
mvn spring-boot:run
```
## API Documentation
Generate Email Template
Endpoint: ```POST /email/generate```
Headers:
```Content-Type: application/json```
```Request Body:
{
  "purpose": "job interview follow-up",
  "recipientName": "HR Manager",
  "tone": "polite"
}
```
```Response (200 OK):
{
  "emailTemplate": "Subject: Interview Follow-Up\n\nDear HR Manager,\n\nThank you for the opportunity to interview for the Software Developer role. I appreciate your time and consideration. I am excited about the possibility of joining your team and contributing to ongoing projects.\n\nPlease let me know if you require any additional information.\n\nBest regards,\n[Your Name]",
  "responseTimeInMs": 1350,
  "timeStamp": "2026-01-06T18:37:02"
}
```
### Health Check
Endpoint: ``` GET /api/health```

Response: ```"Email Generator is running!"```

## API Key Environment Handling

Never hardcode your API key in the project.

Store it in environment variables.


## API key access in code 

```
@Value("${openrouter.api.key}"):
private String apiKey;
```

## How It Works

1. User sends POST request to /email/generate with JSON body.    

2. EmailController receives the request.

3. EmailService calls OpenRouterAIService.

4. OpenRouterAIService sends request to OpenRouter API (gpt-4o-mini).

5. API returns generated email text.

6. EmailService returns JSON response with:

        emailTemplate
   
       responseTimeInMs

          timeStamp

### Sample Output
Request:

```json

{
  "purpose": "project update",
  "recipient": "Ankit",
  "tone": "formal"
}
```
Response:

```json

{
  "emailTemplate": "Subject: Project Update\n\nDear Ankit,\n\nI hope this message finds you well. I wanted to provide a brief update on the project’s progress. We have completed the initial phases and are on track to meet our milestones.\n\nPlease let me know if you would like to discuss this further.\n\nBest regards,\n[Your Name]",
  "responseTimeInMs": 1494,
  "timeStamp": "2026-01-06T18:37:02.296647"
}
```
