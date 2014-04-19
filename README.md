SLATE - a templating engine for mobile
=====
slate is a light-weight cross-platform( android - windows phone ) templating language for mobile devices.

it allows you to write UI's in the form of templates that convert to native mobile UI controls.

it supports styles,themes in a miniature form of css, templates in a concise block form with attributes ( such as list att1=value { ... } )

# templates
### sample template
```javascript
// Loop through calendar and show all data for that day.
// This includes day/date/weather/first event time
			
@each ( day in @calendar.days limit=4 )
{
	list.day
	{
		h6.dayName  @day.dayName			  
		text6.cell	@day.dayDate
		img.iconwt	@day.weatherImage
		text6.cell	@day.tempHigh
		text6.cell	@day.tempLow
		text6.cell	@day.firstEventTimeAsText
		text6.cell	@day.totalEventsText
		text6.cell	@day.totalBDaysAsText
	}
}
```

### output 
https://github.com/kishorereddy/slate-templates/raw/master/media/template-sampleui_1.jpg

### tag formats
- 1. tags start with the name "list"
- 2. followed by optional id prefixed by ":" such as "list:Today"
- 3. followed by optional style prefixed by "." such as "list:Today.board"
- 4. followed by multiple attributes ( key=value )
- 5. followed by a block { } which indicate the tag has children

__Examples:__
- list:Today  ( list id=Today )
- list:Today.board ( list id=Today style=board )
 
### tags supported
- list 
- h1, h2, h3, h4, h5, h6  ( like html )
- text1, text2, text3, text4, text5, text6
- img
- circle
- box

### attributes
each tag can have a collection of attributes in the form of key=value pairs ( like html ).
however, each attribute value does NOT need to be enclosed in quotes "" if there is NO space
- text2 text=Tuesday font-size=30

### notes
- list tags serve as a container for other tags
- list tags can be set to display items either down or across
- each tag has a default attribute

# styles
Styles in slates are setup very similar to CSS but with some dynamic functionality and also some limitations ( to maximize performance ).

```css
vars
{
	baseColor: Black;
	hWeight: bold;
	app-themecolor: @app.themecolor;
	boardwidth: ( @app.screenwidth - 20 );
}
group:core
{
	h1 { font-size: 36; font-weight: @hWeight; color: @baseColor; }
	h2 { font-size: 32; font-weight: @hWeight; color: @baseColor; }
	h3 { font-size: 28; font-weight: @hWeight; color: @baseColor; }
	h4 { font-size: 24; font-weight: @hWeight; color: @baseColor; }
	h5 { font-size: 20; font-weight: @hWeight; color: @baseColor; }
	h6 { font-size: 16; font-weight: @hWeight; color: @baseColor; }
	text1 { font-size: 36; color: @baseColor;   }
	text2 { font-size: 32; color: @baseColor;   }
	text3 { font-size: 28; color: @baseColor;   }
	text4 { font-size: 24; color: @baseColor;   }
	text5 { font-size: 20; color: @baseColor;   }
	text6 { font-size: 16; color: @baseColor;   }

	.area-header { margin:'10,5,10,5'; }
	.icon { width:30dp; margin:'0,0,10,0'; sourceprefix:'/Assets/dark/'; }
	.accent { color: '@app.themecolor'; }
	.bold1 { font-weight:bold; }
	.bold2 { font-weight:semi-bold; }
	.board { width:450px; alignh:center; background-color:'@app.themecolor';}	
	.weather-icon { width:30; }	
	.weather-icon-big { width:100dp; }
	list.col3	  { width:110dp; mode:across; }	
}
```

# code ( android / java )
```Java
// Create instance of the templating service with default values and styles
TemplateService svc = new TemplateService();

// Execute a simple hello world template
TemplateView tview = svc.executeTemplate(" text5.accent.strong 'hello world!' ");

// The engine returns a template view where the root view represents the 1st UI element
// In this example we are adding the generated UI into a container in an android page/activity
page.addView(R.id.pnlContainer, tview.RootView);
```
