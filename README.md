SLATE - a native modern templating engine for mobile devices
=====
slate is a light-weight NATIVE cross-platform( android - windows phone ) templating engine for mobile devices.

###[See wiki for more details!](https://github.com/kishorereddy/slate-templates/wiki)

###[See slatetemplates.com !](http://www.slatetemplates.com)


# goals
A fully **NATIVE** mobile templating engine for android and windows phone
Following are top level goals

| #  | goal | approach |
|:-- |:-- |:-- |
|1. |**NATIVE** | fully native templating engine converts text to native mobile controls |
|2. |**multi-platform** | templating engine converts text to native adnroid / windows phone controls |
|3. |**minimal typing** | size is **40 %** to ** 60% ** less than xml !!! |
|4. |**simplicity** | ease to use elements and attributes |
|5. |**familiarity** | similar syntax to html and css |
|6. |**flexible styling** | tag elements with styles like in CSS |
|7. |**data-binding** | supply data to your templates ( mostly logic-less ) |


# templates
### sample code and generated native mobile UI 
![output here](/media/sample_template_and_output.PNG?raw=true)


### slate calendar app in google play using slate templates
![output here](/media/slate_calendar_slate_usage.png?raw=true)


```javascript
template.core
{
// Loop through calendar and show all data for that day.
// This includes day/date/weather/first event time
			
   @each ( day in @calendar.days limit=4 )
   {
	list.col2
	{
		h6.dayName  @day.dayName			  
		text6.cell	@day.dayDate
		img.iconSmall	@day.weatherImage
		text6.cell	@day.tempHigh
		text6.cell	@day.tempLow
		text6.cell	@day.firstEventTimeAsText
		text6.cell	@day.totalEventsText
		text6.cell	@day.totalBDaysAsText
	}
   }
}
```

### output 
![output here](/media/template-sampleui_1.jpg?raw=true)




###[See wiki page for more info !](https://github.com/kishorereddy/slate-templates/wiki)


# android + windows phone
slate templates convert easy to use and concise templates ( almost 50% smaller than xml ) to native android and windows phone controls!

# optimal productivity
slate templates have been designed for minimal typing, optimal productivy and for rapid UI prototying and development. see [www.slatetemplates.com](http://www.slatetemplates.com) for more detail info as well as the  [wiki](https://github.com/kishorereddy/slate-templates/wiki) page here.
