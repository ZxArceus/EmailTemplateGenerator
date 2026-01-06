
# Email Template Generator with AI

A **Spring Boot REST API** application that generates professional email templates dynamically using **OpenRouter's free LLM API**. Users can send JSON requests to generate emails with different purposes, recipients, and tones.

---

## 🚀 Features

- Generate professional emails dynamically
- Multiple tones supported: polite, formal, friendly, etc.
- Works entirely with free OpenRouter API
- Simple REST API integration (Postman / curl ready)
- Tracks response time and timestamp for generated emails
- API key handled securely via environment variables

---

## 💻 Technology Stack

| Component           | Version / Details        |
|--------------------|-------------------------|
| Java               | 17+                     |
| Spring Boot        | 3.x                     |
| AI Model Provider  | OpenRouter (gpt-4o-mini) |
| HTTP Client        | Spring RestTemplate      |
| Testing            | Postman, curl           |
| Build Tool         | Maven                   |

---

## 📝 Prerequisites

- Java 17+
- Maven
- Postman or curl
- OpenRouter API Key (Sign up [here](https://openrouter.ai/))

---

## ⚙️ Setup & Configuration

### 1️⃣ Clone the repository

```bash
git clone https://github.com/yourusername/email-template-generator.git
cd email-template-generator
```
2️⃣ Set your OpenRouter API key
Windows (Command Prompt)

```setx OPENROUTER_API_KEY "YOUR_OPENROUTER_API_KEY"```


bash
Copy code
export OPENROUTER_API_KEY="YOUR_OPENROUTER_API_KEY"
⚠️ Restart your IDE or terminal after setting the environment variable.

3️⃣ Update application.properties
properties

```
openrouter.api.key=${OPENROUTER_API_KEY}
server.port=8080
```
4️⃣ Build and Run

```
mvn clean install
mvn spring-boot:run
```
📡 API Endpoint
POST /generate
```
Content-Type: application/json
```

Body Parameters
Parameter	Type	Description
purpose	String	Subject/purpose of the email
recipient	String	Recipient name
tone	String	Email tone (polite, formal, friendly)

🔹 Example Request JSON
```json

{
  "purpose": "job interview follow-up",
  "recipient": "HR Manager",
  "tone": "polite"
}
```
🔹 Example curl Request
bash
```
curl -X POST http://localhost:8080/generate \
-H "Content-Type: application/json" \
-d '{
  "purpose": "job interview follow-up",
  "recipient": "HR Manager",
  "tone": "polite"
}
```
🔹 Example Response JSON
```json

{
  "emailTemplate": "Subject: Interview Follow-Up\n\nDear HR Manager,\n\nThank you for the opportunity to interview for the Software Developer role. I appreciate your time and consideration. I am excited about the possibility of joining your team and contributing to ongoing projects.\n\nPlease let me know if you require any additional information.\n\nBest regards,\nAnkit",
  "responseTimeInMs": 1350,
  "timeStamp": "2026-01-06T18:37:02"
}
```
✅ \n represents line breaks; Postman displays them correctly.

🔐 API Key Environment Handling
Never hardcode your API key in the project.

Store it in environment variables:

bash
Copy code
OPENROUTER_API_KEY
Access it in Spring Boot via 
```@Value("${openrouter.api.key}"):```
private String apiKey;
🛠 Project Structure
css
Copy code
src/
 └── main/
     └── java/com/example/emailapp/
         ├── Controller/
         │    └── EmailController.java
         ├── Service/
         │    ├── EmailService.java
         │    └── OpenRouterAIService.java
         └── model/
              ├── EmailRequest.java
              └── EmailResponse.java
application.properties
pom.xml
README.md
🔧 How It Works
User sends POST request to /generate with JSON body.

EmailController receives the request.

EmailService calls OpenRouterAIService.

OpenRouterAIService sends request to OpenRouter API (gpt-4o-mini).

API returns generated email text.

EmailService returns JSON response with:

emailTemplate

responseTimeInMs

timeStamp

⚡ Sample Output
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
