# Slip 17 - Question 2 - PhoneGap Contacts

## index.html

```html
<!DOCTYPE html>
<html>
<head><title>Contacts</title><script src="cordova.js"></script></head>
<body>
<input id="name" placeholder="Name">
<input id="phone" placeholder="Phone">
<button onclick="createContact()">Create</button>
<button onclick="searchContact()">Search</button>
<button onclick="cloneContact()">Clone</button>
<button onclick="removeContact()">Remove</button>
<pre id="out"></pre>
<script src="js/index.js"></script>
</body>
</html>
```

## js/index.js

```javascript
let lastContact = null;
function createContact(){
    let c = navigator.contacts.create();
    c.displayName = document.getElementById('name').value;
    c.phoneNumbers = [new ContactField('mobile', document.getElementById('phone').value, true)];
    c.save(x => { lastContact = x; out.textContent = 'Saved'; }, e => out.textContent = 'Error');
}
function searchContact(){
    navigator.contacts.find(['displayName','phoneNumbers'], cs => out.textContent = JSON.stringify(cs), null, {filter: document.getElementById('name').value, multiple: true});
}
function cloneContact(){
    if(lastContact){ let c = lastContact.clone(); c.displayName += ' Copy'; c.save(); out.textContent = 'Cloned'; }
}
function removeContact(){
    if(lastContact){ lastContact.remove(() => out.textContent = 'Removed'); }
}
```
