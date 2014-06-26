package com.codehelixsolutions.slate.sampleapp.lib;

import com.codehelixsolutions.slate.sampleapp.R;
import com.slate.core.common.BoolMessageItem;
import com.slate.templates.templating.EvaluatorException;
import com.slate.templates.templating.TemplateService;
import com.slate.templates.templating.TemplateView;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import android.widget.TextView;

public class ActivityBase extends Activity {
		
	private FileHelper _fileHelper;
	private TemplateService _templateSvc;
	
	protected void configureActionBar()
	{
		try
		{
			ActionBar actionBar = getActionBar();
			setupActionBar(actionBar);
			actionBar.setDisplayShowTitleEnabled(false);
			actionBar.setDisplayShowTitleEnabled(true);
		}
		catch(Exception ex)
		{
			// NOTE: Use slate.core.logging for logger.
			Logger.error("activity", "Unable to configure action bar" + ex.getMessage(), ex);
		}
	}
	
	
	// @summary: Convenience method to inflate the slate template and load the 
	// root view into the container id
	// @param fileOrContent: The file name or template content
	// @param isFile: Whether or not the first param is a file path or content.
	public TemplateView inflateTemplateInto(String fileOrContent, boolean isFile, int resContainerId, int errorMessageViewId)
	{
		TemplateView tview = null;
		try
		{
			tview = inflateTemplate(fileOrContent, isFile);
			ViewGroup group = (ViewGroup)findViewById(resContainerId);
			if(group == null)
				return null;
			
			group.addView(tview.RootView);
		}
		catch(Exception ex)
		{
			String fileName = isFile ? fileOrContent : "";
			Logger.error("page", "Error loading template : " + fileName + ", " + ex.getMessage(), ex);
			TextView msg = (TextView)findViewById(errorMessageViewId);
			if(msg != null)
				msg.setText(ex.getMessage());
		}
		return tview;
	}	
	
	
	// @summary: Convenience method to inflates the slate template.
	// @param fileOrContent: The file name or template content
	// @param isFile: Whether or not the first param is a file path or content.
	public TemplateView inflateTemplate(String fileOrContent, boolean isFile) throws Exception
	{
		if(isFile)
			return inflateTemplateFile(fileOrContent);
		return inflateTemplateText("", fileOrContent);		
	}
	
	
	// @summary: Convenience method to inflates the slate template file
	// @param fileOrContent: The file path
	public TemplateView inflateTemplateFile(String filePath) throws Exception
	{
		String templateContent = getAssetsFileContent(filePath);
		return inflateTemplateText(filePath, templateContent);
	}
	
	
	// @summary: Convenience method to inflates the slate template file
	// @param fileOrContent: The file path
	public TemplateView inflateTemplateText(String name, String content) throws Exception
	{
		TemplateView tview = null;
		initializeTemplateService();
		tview = _templateSvc.executeTemplate(content);
		return tview;
	}
	
	
	// @summary: Loads the file content as string form the file path supplied
	// @param filePath: The name of the file in the assets folder.
	public String getAssetsFileContent(String filePath)
	{
		if(_fileHelper == null)
			_fileHelper = new FileHelper(getApplicationContext());
		
		String fileContent = _fileHelper.getAssetsFileText(filePath);
		return fileContent;
	}
	
	
	private void initializeTemplateService() throws Exception
	{
		if(_templateSvc == null)
		{			
			// 1. intialize using the activity.
			// This sets the android context, resources, asset manager
			_templateSvc = new TemplateService();
			_templateSvc.initialize(this);
			
			// 2. setup the references to the resource strings and images.
			_templateSvc.Context.ResourceStyles = R.style.class;
			_templateSvc.Context.ResourceStrings = R.string.class;
			_templateSvc.Context.ResourceImages  = R.drawable.class;
			
			// 3. load the theme
			_templateSvc.registerDefaultStyles();
			_templateSvc.setThemeVariable("textColorAccent", "#2980B9", true);
			_templateSvc.loadThemeFile("slate_theme_default.txt");
			
			// 4. OPTIONAL settings
			_templateSvc.getSettings().Use24HourClock = false;
			
			// 5. OPTIONAL: setup some sample data to use in the template.
			_templateSvc.setData("sampleData",  "this data supplied from code via svc.setData(...)");		
		}
	}
	
	
	private static void setupActionBar(ActionBar bar)
	{
		String actionBarColor = "#2980B9";
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(actionBarColor)));
	}
	
	/*
	private TemplateView inflateTemplateFile22(String fileName) throws Exception
	{
		TemplateService svc = new TemplateService();
		
		// 1. give the templating the activity
		// This is the easiest way to setup the context,
		// resources, windows manager on the templating system.
		svc.initialize(this);
		
		// 2. Now set the resource strings / images
		svc.Context.ResourceStyles = R.style.class;
		svc.Context.ResourceStrings = R.string.class;
		svc.Context.ResourceImages = R.drawable.class;

		// 3. Load the theme file ( just like css )
		svc.registerDefaultStyles();
		svc.loadThemeFile("theme_default.txt");

		// 4. Put some data into template
		svc.setData("moreHelp", "check the help section for more upcoming features");    	
		
		// 4. Now execute template and get view
		TemplateView tview = svc.executeTemplateFile(fileName);
		return tview;
	}
	*/
}
