# PokeScanner
A real-life Pokedex that allows you to scan the area for Pkmn using your phone's camera. The application using A.I Object classification to detect to classify Pkmn within the 1st generation.

### Features

- [ ] Generation 1 Pkmn classification
- [ ] Pokedex Journel 
- [ ] Stats screen to view overall image captured

### Screens

- [ ] Home Menu - Starts off with the camera view being active. From here the user has the option to take a picture or move over to a different screen through the bottom nativation menu.

![Home screen](wireframes/HomeScreen.png)

- [ ] Pokedex Journel - Should you all the pkmn that have been classified so far within the generation 1 pokedex. Should allow the user to access the `pkmn info screen` of a selected pkmn only if they have classified it by taking a picture of it.

![Pokedex Screen](wireframes/PokedexScreen.png)

- [ ] Pkmn info - A screen accessable through the Pokedex when a pkmn is selected, shows the various info of the pkmn such as pokedex #, pkmn name, species, and image of identification.

- [ ] Stats - Stats of using the application so far, how many pkmn you have captured, how many images you have taken, and total pkmn entries completed.

![Stats Screen](wireframes/StatsScreen.png)

### Progress
#### **7/13/2024**
Left this project on the back burner for a while. I'm still working on the camera system. When the user clicks on camera button to take image that is current on preview, what happens to image? Image is analysis and feed into model, Dialog alert comes up with predicted pokemon. To preceed, click OK, dialog goes away. From this point, image is saved and recorded within the pkmn_captured DB.

In a pokemon journal entry, preview images are shown below the full detail cards of the pokemon. Each image represents when the app predicted that image contain the specific pokemon. For each preview, there should be a way to view the image as a whole within the app, in the view there should be an icon button to delete the image and an icon button to download image to store in user's photos directory.


#### **5/29/2024**
Next stages of the application is to make a camera system for the home page followed by a Journal System. Taking a picture should bring up a preview of the image and ask the user to process the image in a Yes/no dialog. If Yes, prediction is made and that prediction is added as an entry to respective pokemon, if no, image is discarded. Within the Journal, when clicking on an entry, it will show the pokemon's entry along with images that were taken of that pokemon. Each image should be downloadable and deleteable. 

#### **5/7/2024** 
Currently, the plans on how the user will interact with the application have been made. A database schemea
has been made to represent how the stateful data should be stored using the Room API in Kotlin. The next steps are to 
develop the UI that follows the ViewModel Arch, along with creating a Navigation interface between all screen. These screens
shouldn't operate and should only act as Views for the moment. 

### Made With

- Kotlin
- Tensorflow
