SLATE - a templating engine for mobile
=====
slate is a light-weight cross-platform( android - windows phone ) templating language for mobile devices.

it allows you to write UI's in the form of templates that convert to native mobile UI controls.

it supports styles,themes in a miniature form of css, templates in a concise block form with attributes ( such as list att1=value { ... } )

###[See wiki for more docs!](https://github.com/kishorereddy/slate-templates/wiki)

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
![output here](/media/template-sampleui_1.jpg?raw=true)
https://github.com/kishorereddy/slate-templates/raw/master/media/template-sampleui_1.jpg


## goals
1. minimal typing / size ( 33 % less than xml !!! )
2. simplicity and conciseness to element structure
3. familiarity ( similar syntax to html and css )

## syntax
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


## examples
| tag part | example | desc
| :------------ | :------------ | :------------ |
| name | h1:title | heading text with name='title' | 
| style | h1.accent | heading with css style='accent' | 
| name + style | h1:title.accent | heading with name and style set | 
| name + multiple styles | h1:title.accent.strong | set multiple styles  | 
| default attribute value | h1:title.accent 'heading 1' | text='heading 1' first attribute key optional | 
| explicit attribute | h1:title.accent text='heading 1' | heading with text='heading 1'  | 
| explicit attributes | h1:title.accent text='heading 1' alignh='center' | multiple attributes  | 
| attribute enclosure | list( width=100 height=200 ) { } | multiple atts enclosed by ( ) - optional  |
| children | list across { text1 'test1' } | use braces { } to designate block/children.    | 

 
## supported tags
| tag | purpose  | default attribute | example |
| :------------ | :------------ | :------------ | :------------ |
| h1 - h6 | heading text | text | h1 'heading 1' |
| text1 - text6 | normal text | text | text5 'this is text 6' |
| list | container | mode=( across, down ) | list across { ... } |
| img  | image | src | img 'weather_sunny.png' |
| circle | cirlce shape | width | circle 30 |
| box| box to hold only 1 element | width |  |


## attributes
each tag can have a collection of attributes in the form of key=value pairs ( like html ).
however, each attribute value does NOT need to be enclosed in quotes "" such as for numbers and colors and predefined values such as left, center, right.
"list mode=across width=200 { .. }"

below are the most common attributes supported ( which are the same as most android/windows phone attributes )

| name | type | used for | default value | examples |
| :------------ | :------------ | :------------ | :------------ |:------------ |
| color| string | **h1** to **h6** and **text1** to **text6** | default text color | color='Red' or color='#242424' |
| background-color | string | **list**, **box** |  default background color | color='Red' or color='#242424' |
| mode | across or down | **list** | down | list mode=across or list across |
| width | number | all | match_parent | width=200 |
| height| number | all | wrap_content | height=200 | 
| margin | string | all | 0| margin='10,0,10,5' | 
| margin-left | number | all | 0 | margin-left=200 |
| margin-top | number | all | 0 |  margin-top=200 |
| margin-left | number | all | 0 | margin-left=200 |
| margin-bottom | number | all | 0 |  margin-bottom=200 |
| alignh | left or center or right  |  all | left | alignh=center |

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
