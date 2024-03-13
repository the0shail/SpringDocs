package the.zero.shail.sender.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import the.zero.shail.sender.models.DocumentModel;
import the.zero.shail.sender.models.UserModel;
import the.zero.shail.sender.repositories.DocumentRepository;
import the.zero.shail.sender.repositories.StatusRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final StatusRepository statusRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository, StatusRepository statusRepository) {
        this.documentRepository = documentRepository;
        this.statusRepository = statusRepository;
    }

    public List<DocumentModel> findAll(){
        return documentRepository.findAll();
    }

    public DocumentModel findById(int id){
        return documentRepository.findById(id).orElse(new DocumentModel());
    }

    @Transactional
    public DocumentModel create(DocumentModel documentModel){
        documentModel.setStatus(statusRepository.getStatusModelById(2));
        documentRepository.save(documentModel);
        return documentModel;
    }
}
