package by.epamlab;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import by.epamlab.beans.Document;
import by.epamlab.dao.DocumentStore;
import by.epamlab.exception.ElementNotFoundException;

public class DocumentsService implements ServiceREST {
    private static final Logger LOG = Logger.getLogger(Document.class);
    private DocumentStore store = new DocumentStore();

    public Response getDocuments() {
        LOG.info("LIST: get Documents");
        return Response.status(Response.Status.OK).entity(store.list()).build();
    }

    public Response getDocument(final int id) throws ElementNotFoundException {
        LOG.info("GET: Document ID (" + id + ")");
        return Response.status(Response.Status.OK).entity(store.getById(id)).build();
    }

    public Response documentCreate(final Document document) {
        LOG.info("CREATE: new Document");
        return Response.status(Response.Status.CREATED).entity(store.create(document)).build();
    }

    public Response getDocumentUpdate(final Document document) throws ElementNotFoundException {
        LOG.info("UPDATE: Document");
        store.update(document);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public Response getDocumentDelete(final int id) {
        LOG.info("DELETE: Document by ID (" + id + ")");
        store.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public Response getDocumentsWithShortestChapters() {
        LOG.info("GET: Documents sith shortest Chapters (can be gt 1) ");
        LOG.info("AND return Response Status code - NOT_IMPLEMENTED (501) ");
        return Response.status(Response.Status.NOT_IMPLEMENTED).entity(store.getChapterShortest()).build();
    }

}
