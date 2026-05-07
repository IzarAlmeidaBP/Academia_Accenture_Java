package acc.br.student.controller;

import acc.br.student.domain.ChatLog;
import acc.br.student.repository.ChatLogRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.JOptionPane;

@RestController
public class GenAiController {

    private final ChatClient chatClient;
    private final ChatLogRepository repository;

    public GenAiController(ChatClient.Builder builder, ChatLogRepository repository) {
        this.chatClient = builder.build();
        this.repository = repository;
    }

    @GetMapping("/q")
    public String chat() {
        System.setProperty("java.awt.headless", "false");
        String prompt = JOptionPane.showInputDialog("O que desejas perguntar ao Gemini?");

        if (prompt == null || prompt.trim().isEmpty()) {
            return "Operação cancelada pelo utilizador.";
        }

        // AGORA SIM! Chamada real para a API do Gemini com sua nova chave:
        String resposta = chatClient.prompt().user(prompt).call().content();

        JOptionPane.showMessageDialog(null, resposta, "Resposta do Gemini", JOptionPane.INFORMATION_MESSAGE);

        ChatLog log = new ChatLog();
        log.setPrompt(prompt);
        log.setResposta(resposta);
        repository.save(log);

        return "Pergunta e resposta guardadas com sucesso no H2!";
    }
}