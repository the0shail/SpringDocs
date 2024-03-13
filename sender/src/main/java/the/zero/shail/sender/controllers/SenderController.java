package the.zero.shail.sender.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import the.zero.shail.sender.listeners.Sender;
import the.zero.shail.sender.models.DocumentModel;
import the.zero.shail.sender.services.DocumentService;
import the.zero.shail.sender.util.ServerResponse;

import java.time.LocalDateTime;

@Log4j2
@RestController
@RequestMapping("/documents")
public class SenderController {
    private final ObjectMapper objectMapper;
    private final Sender sender;

    private final DocumentService documentService;



    @Autowired
    public SenderController(ObjectMapper objectMapper, Sender sender, DocumentService documentService) {
        this.objectMapper = objectMapper;
        this.sender = sender;
        this.documentService = documentService;
    }

    @PostMapping
    public ResponseEntity<ServerResponse<DocumentModel>> create(@RequestBody DocumentModel documentModel) throws JsonProcessingException {
        DocumentModel newDocument = documentService.create(documentModel);
        String json = objectMapper.writeValueAsString(newDocument);
        sender.send(json);

        return new ResponseEntity<>(
                new ServerResponse<>(
                        HttpStatus.CREATED.value(),
                        HttpStatus.CREATED.toString(),
                        newDocument,
                        LocalDateTime.now()
                ), HttpStatus.CREATED
        );

    }
}
