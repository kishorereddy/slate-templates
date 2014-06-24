SLATE - a native modern templating engine for mobile devices
=====
slate is a light-weight NATIVE cross-platform( android - windows phone ) templating language for mobile devices.

###[See wiki for more details!](https://github.com/kishorereddy/slate-templates/wiki)


# goals
A fully **NATIVE** mobile templating engine for windows phone and android ( PROOF-OF-CONCEPT )
Following are top level goals

| #  | goal | approach |
|:-- |:-- |:-- |
|1. |**NATIVE** | fully native templating engine converts text to native mobile controls |
|2. |**multi-platform** | templating engine converts text to native adnroid / windows phone controls |
|3. |**minimal typing** | size is **33 %** less than xml !!! |
|4. |**simplicity** | ease to use elements and attributes |
|5. |**familiarity** | similar syntax to html and css |
|6. |**flexible styling** | tag elements with styles like in CSS |
|7. |**data-binding** | supply data to your templates ( mostly logic-less ) |


# templates
### sample 
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
![output here](/media/template-sampleui_1.jpg?raw=true)
https://github.com/kishorereddy/slate-templates/raw/master/media/template-sampleui_1.jpg



### tag syntax
the fundamental structure of the tag form is :

| tag | :name | .style | .style2 | default attribute value | remaining attributes | body |
| :------------ | :---------- | :---------- |:---------- |:---------- |:---------- |:---------- |
| list| :event| .accent | .contrast| down | height=200 | {  }  |
| text5 | :title | .accent | .strong | 'this is some text' | color='Red' |  |

```html
list down height=200
{   
   img 'icon_event' width=30
   text5:title.accent 'Dinner in the city'
   text5.time      '@7 pm'
   text6.location  'City winery'
}

```

###[See template wiki page for more info !](https://github.com/kishorereddy/slate-templates/wiki/templates)
###[See tags wiki page for more info !](https://github.com/kishorereddy/slate-templates/wiki/tags)


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
import com.slate.templates.templating.*;

// Create instance of the templating service with default values and styles
TemplateService svc = new TemplateService();

// Execute a simple hello world template
TemplateView tview = svc.executeTemplate(" text5.accent.strong 'hello world!' ");

// The engine returns a template view where the root view represents the 1st UI element
// In this example we are adding the generated UI into a container in an android page/activity
page.addView(R.id.pnlContainer, tview.RootView);
```
