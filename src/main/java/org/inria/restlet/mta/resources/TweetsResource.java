package org.inria.restlet.mta.resources;

import java.util.Collection;

import org.inria.restlet.mta.backend.Backend;
import org.inria.restlet.mta.internals.Tweet;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.FileRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class TweetsResource extends ServerResource {
    private Collection<Tweet> tweets;
    
    /** Backend. */
    private Backend backend_;
    
    /**
     * Constructor.
     * Call for every single user request.
     */
    public TweetsResource()
    {
        super();
        backend_ = (Backend) getApplication().getContext().getAttributes()
                .get("backend");
    }

    @Get("html")
    public Representation getTweetsHtml() {
    	JsonRepresentation result = new JsonRepresentation(toJSON(tweets));
    	result.setIndenting(true);
    	return result;
    }
    
    private static JSONObject toJSON(Collection<Tweet> tweets){
    	JSONObject result = new JSONObject();
    	int numTweet = 1;
    	for(Tweet tweet: tweets){
    		
    		try {
				result.put(String.valueOf(numTweet), tweet.getText());
			} catch (JSONException e) {	}
    	}
    	return result;
    }
    
    
    
}
