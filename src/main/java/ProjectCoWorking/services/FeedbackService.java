package ProjectCoWorking.services;

import ProjectCoWorking.dao.FeedbackDao;
import ProjectCoWorking.models.Feedback;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class FeedbackService {
    //--------- get feedback ----------
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Feedback> getFeedback_JSON() {
        List<Feedback> feedbacks = FeedbackDao.getAllFeedback();
        return feedbacks;
    }
    //--------- get feedback by id----------
    // URI:
    // contextPath/servletPath/feedback/{feedbackId}
    @GET
    @Path("/{feedbackId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Feedback getFeedback(@PathParam("feedbackId") Integer feedbackId){
        return FeedbackDao.getFeedback(feedbackId);
    }
    //--------- add feedback ----------
    // URI:
    // contextPath/servletPath/feedbacks
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Feedback addFeedback(Feedback feedback) {
        return FeedbackDao.addFeedback(feedback);
    }
    //--------- update feedback ----------

    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Feedback updateFeedback(Feedback feedback) {
        return FeedbackDao.updateFeedback(feedback);
    }
    //--------- delete feedback ----------
    @DELETE
    @Path("/{feedbackId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteFeedback(@PathParam("feedbackId") Integer feedbackId) {
        FeedbackDao.deleteFeedback(feedbackId);
    }
}
