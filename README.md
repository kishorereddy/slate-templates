SLATE - a native modern templating engine for mobile devices
=====
slate is a light-weight NATIVE cross-platform( android - windows phone ) templating engine for mobile devices. Slate templates are available currrently for android and windows phone. They allow cross-platform UI development allowing you to create native UIs for both android and windows phone. 

| platform | notes |
|:-- |:-- |
| ![output here](/media/android.png?raw=true) | currently available for android, see sample app |
| ![output here](/media/windows.png?raw=true) | currently developed for windows, sample app not yet available |


# example
Here is a sample template in slate that generate a fully NATIVE UI for android and windows phone. Slate support tags that are similar to html. The templates are easy to learn and use, almost 40% to 60% smaller than native android xml layouts, offer data binding and many other features. See the wiki page and [www.slatetemplates.com](http://www.slatetemplates.com) for more information.

![output here](/media/sample_template_and_output.PNG?raw=true)


# live use
Slate templates are used in a live android calendar app on google play. The templates are used to generate cards or what we call "boards" on the home page. [Check out Slate Calendar for live examples.](https://play.google.com/store/apps/details?id=com.codehelixsolutions.slatecalendar)

![output here](/media/slate_calendar_slate_usage.png?raw=true)



# goals
Here are some of the top uses for slate templates for both personal projects as well as commercial. Please note this is the first initial release of slate templates ( in beta ) and we will soon provide a beta 2 version.

| #  | goal | approach |
|:-- |:-- |:-- |
|1. |**NATIVE** | fully native templating engine converts text to native mobile controls |
|2. |**multi-platform** | templating engine converts text to native adnroid / windows phone controls |
|3. |**minimal typing** | size is **40 %** to ** 60% ** less than xml !!! |
|4. |**simplicity** | ease to use elements and attributes |
|5. |**familiarity** | similar syntax to html and css |
|6. |**flexible styling** | tag elements with styles like in CSS |
|7. |**data-binding** | supply data to your templates ( mostly logic-less ) |


# another sample
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
