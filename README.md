SLATE - a templating engine for mobile
=====
slate is a light-weight cross-platform( android - windows phone ) templating language for mobile devices.

it allows you to write UI's in the form of templates that convert to native mobile UI controls.

it supports styles,themes in a miniature form of css, templates in a concise block form with attributes ( such as list att1=value { ... } )

# Templates
### sample template
```javascript
template.weeksummary
{
  list.area-weather
  {
      list across
      {           
          img.weather-icon-big @weather.currentIconImage
          list.area-temp
          {
              text2 @weather.currentTemp
              list across
              {
                  text4.weather-tempmax @weather.todayHighTemp
                  text4.weather-tempsep '/'
                  text4.weather-tempmin @weather.todayLowTemp
              }
          }
      }
      text6.weather-text @weather.currentConditions
  }
}
```
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

# Styles
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

## code ( java )
```Java
TemplateService svc = new TemplateService();
TemplateView tview = svc.executeTemplate(" text5.accent.strong 'hello world!' ");

page.addView(R.id.pnlContainer, tview.RootView);
```
