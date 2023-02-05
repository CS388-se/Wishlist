# Android Project 2 - *Wishlist*

Submitted by: **Stephen Ebrahim**

**Wishlist** is a wishlist app that helps the user keep track of what they want to buy.

Time spent: **6** hours spent in total

## Required Features

The following **required** functionality is completed:

- [X] **User can add an item to their wishlist**
- [X] **User can see their list of items based on previously inputted items**

The following **optional** features are implemented:

- [X] Wishlist app is 🎨 **customized** 🎨
- [X] User can delete an item by long pressing on the item
- [X] User can open an item's URL by clicking on the item

The following **additional** features are implemented:

* [ ] List anything else that you can get done to improve the app functionality!
* [X] I added a functionality where the keyboard is slid down on submit.
* [X] I added a functionality where the fields are cleared on submit.

## Video Walkthrough

Here's a walkthrough of implemented user stories:

![Kapture 2023-02-05 at 09 38 04](https://user-images.githubusercontent.com/66531257/216825958-c88817d7-ce91-4805-b213-fb66e11775ab.gif)

GIF created with [Kap](https://getkap.co/).

## Notes

Describe any challenges encountered while building the app:

The biggest challenge encountered while building the app is how opening the keyboard affects the views on the screen. As the keyboard slid up, the views were either shifted upwards or became invisible. To disable this behavior, I added the following line in the manifiest file to fix this issue: `android:windowSoftInputMode="adjustPan"`

## License

    Copyright [2023] [Stephen Ebrahim]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
