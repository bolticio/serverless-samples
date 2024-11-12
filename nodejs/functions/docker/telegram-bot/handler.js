import axios from 'axios';

export const handler = async (req, res) => {
    try {
        const userToken = "<YOUR_TOKEN_HERE>";
        if (!userToken) {
            return res.status(400).json({ error: 'Token is required' });
        }

        const body = typeof req.body === 'string' ? JSON.parse(req.body) : req.body;
        const message = body.message;
        const chatId = message?.chat?.id;

        if (!chatId) {
            return res.status(400).json({ error: 'Chat ID is missing in the message' });
        }

        const BASE_URL = `https://api.telegram.org/bot${userToken}/sendMessage`;
        await axios.post(BASE_URL, {
            text: message.text,
            chat_id: chatId,
        });

        res.status(200).json({ message: "Response sent successfully" });
    } catch (error) {
        const msg = `Error sending message: ${error.message}`;
        console.error(msg);
        res.status(500).json({ error: msg });
    }
};
