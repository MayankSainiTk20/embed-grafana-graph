package org.jenkinsci.plugins.buildlinkplugin;

import hudson.model.Action;
import hudson.model.AbstractProject;

import java.util.ArrayList;
import java.util.List;

public class ProjectPage implements Action {
private AbstractProject<?,?> job;
private List<LinkAction> links = new ArrayList<LinkAction>();
private String urlname;
private String displayname;
private int i=0;
 public List<LinkAction> getLinks() { return links; }

 	public ProjectPage(AbstractProject<?,?> job,List<LinkAction> links) {
		
	this.job=job;
	this.links=links;
 	}
	public AbstractProject getBuild() {
		
		return this.job;
	}
	
	@Override
	public String getIconFileName() {
		
		return this.links.get(i).getIconFileName();
	}

	@Override
	public String getDisplayName() {
		
		this.displayname=this.links.get(i).getDisplayName();
		i++;
		if(i==links.size()){
			i=0;
		}
		return this.displayname;
	}

	@Override
	public String getUrlName() {
		// TODO Auto-generated method stub
		return "grafana";
	}

	public String getIframeURL() 
	{
		this.urlname=this.links.get(i).getUrlName();
		
	return this.urlname;
	}
	

}
