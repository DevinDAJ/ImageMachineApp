# ImageMachineApp
a Java Android Machine Image Gallery App

Function Description
    • The app is called "Image Machine”
    • The app will have 2 menu: "Machine Data" and "Code Reader”
    • When opening the app for the first time OR user click menu "Machine Data", the app will show a page with:
        ◦ list of Machine ( name and type ) sorted alphabetically
        ◦ button to sort the list
        ◦ "Add Machine Data" button
    • The "list of machine" page can be sorted by Machine Name or Machine Type
    • When selecting any Machine Name the app will go to "Machine Data Detail" Page. It should show The following fields (information):
        ◦ Machine Id ( autogenerated - random - unique)
        ◦  Machine Name (text)
        ◦ Machine Type (text)
        ◦ Machine QR code Number ( number )
        ◦ Last Maintenance Date (date, with datepicker)
        ◦ Button "Machine Image", when this button clicked it will go to gallery then the user will be able to multi select image (max 10) and be associated with this machine , and the image(s) thumbnail will be shown at the bottom of this Machine Data Detail page
        ◦ If the thumbnail is clicked it will then show the larger size version of that image (full screen) .
        ◦ For machine that has images associated with it, user can also select one or more specific thumbnail(s) and disassociate them from the machine ( delete the images ) . NOTE THAT Deleted image will only remove the thumbnail from the app but NOT delete the image in the gallery
    • The app need also "Edit Machine data" and "Delete Machine data" feature
    • When user select Code Reader menu it will show the back camera, and the camera shall be able to read QR code and if that QR code number matches with one machine QR code number, the app will redirect to the "Machine Data Detail" Page for that machine

Status : Unfinished

Reason : Ran out of time
