# Telegram Echo Bot

This project is a simple Telegram echo bot built using Node.js, designed to run on a serverless platform using Boltic.

## Prerequisites

Before starting, ensure you have the following:

- Node.js `v18` or later installed on your machine
- [Telegram account](https://web.telegram.org/)
- [Boltic account](https://console.boltic.io) for serverless deployment

## Getting Started

Follow these steps to set up and deploy your Telegram bot on Boltic:

### 1. Set Up Your Project in Boltic

1. Go to [Boltic Console](https://console.boltic.io) and create a new serverless project.
   - For more details, refer to the [Boltic documentation](https://docs.boltic.io/docs/compute/serverless/launch-your-application/create-app-console).

### 2. Create a Bot on Telegram

1. In your Telegram app, start a conversation with [@BotFather](https://web.telegram.org/#/im?p=@BotFather) and send the following command:
   ```
   /newbot
   ```

| ![Create Telegram Bot](/assets/images/telegram-botfather-newbot.png) |
|-|

2. Follow BotFather’s instructions:
   - **Choose a name** for your bot (e.g., “EchoBot”).
   - **Select a username** for your bot, which must end with “bot” (e.g., “EchoBot_bot”).
   - BotFather will provide a unique token for your bot, which is needed to authenticate with the Telegram API.

| ![Created Telegram Bot with details](/assets/images/telegram-botfather-create-bot.png) |
|-|

> **Note**: Save this token securely as you’ll need it in the next steps.

### 3. Add Your Token to the Code

1. Open the `handler.js` file in your project.
2. Replace `<YOUR_TOKEN_HERE>` with the token provided by BotFather:
   ```javascript
   const userToken = "<YOUR_TOKEN_HERE>";
   ```

### 4. Deploy Your Bot to Boltic

1. Once your project is set up, deploy it on Boltic.
   - Follow the [Boltic deployment guide for Node.js](https://docs.boltic.io/docs/compute/serverless/language-and-framework-guides/node#deploy-to-boltic) for detailed instructions.

2. After deployment, copy the serverless application URL from Boltic, as you’ll need it to set up your Telegram webhook.

| ![Copy serverless URL](/assets/images/copy-serverless-url.png) |
|-|

### 5. Set Up the Telegram Webhook

To connect your bot to Telegram, set up a webhook using the token and Boltic URL. Define your token and URL as shell variables, then run the following command in your terminal:

```bash
TELEGRAM_BOT_TOKEN="<YOUR_TOKEN_HERE>"
BOLTIC_SERVERLESS_URL="<YOUR_URL_HERE>"

curl --request POST \
  --url https://api.telegram.org/bot${TELEGRAM_BOT_TOKEN}/setWebhook \
  --header 'content-type: application/json' \
  --data "{\"url\": \"${BOLTIC_SERVERLESS_URL}\"}"
```

### 6. Test Your Bot

Your bot is now live! Say “hello” to your bot on Telegram to test it out 🤖

| ![Telegram Bot Hello](/assets/images/telegram-bot-response.png) |
|-|

---

🏆 **Congratulations!** Your Telegram echo bot is now ready to respond to messages.
