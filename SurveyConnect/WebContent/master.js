function submitCreds() {
	//do registration like this
	var username = document.getElementById('emailid');
	//alert(username.value);
	var password = document.getElementById('passid');
	//alert(password.value);
	var form = document.getElementById("myform");
    form.submit();

}


function submitCredsSignUp() {
	alert("Hello");
	var username = document.getElementById('signupemailid');
	//alert(username.value);

	var password = document.getElementById('signuppassid');
	
	var repPassword = document.getElementById('repassid');//get repassid from new html
	
	

	var accountType = document.getElementById('accountType').value;
	//get accid from new html/ decide if we need tto have something like a chooser	
	//alert(accountType.value);
	
	//var value = accountType.options[accountType.selectedIndex].value;
	//var text = accountType.options[accountType.selectedIndex].text;
	//alert(accountType.value);


	var department = document.getElementById('myInput').value; 
	
	var gradYear = document.getElementById('year').value;
	
	var major = document.getElementById('major').value;
	
	var position = document.getElementById('position').value; 
	
	var matchBool = checkPass(password.value, repPassword.value);
	
	if (!matchBool) {
		return;
	}
    form.submit();
    
}
function validatePasswords() {
	alert("Hello");
}

function checkPass(pass, repass) {
	alert(pass + " " + repass);
	if(pass != repass) {
		
		return false;
	}
	return true;
}

let profile;
function onSignIn(googleUser) {
	System.out.println("hello");
	profile = googleUser.getBasicProfile();
	System.out.println(profile.getEmail());
}


//signupjs code:


const renderOrganizationFillout = function() {
  return `<div class="formDiv">
            <div class="field">
              <label class="label">Department</label>
              <form autocomplete="off">
                <div class="control, autocomplete" style="width:300px;">
                  <input class="input" id="myInput" type="text" name="myInput" placeholder="i.e. Computer Science"/>
                </div>
              </form>
            </div>
            <div class="field">
              <label class="label">Position</label>
              <div class="control">
                <div class="select">
                  <select id = 'position' name='position'>
                    <option value = '0'>Choose One</option>
                    <option value = 'Professor'>Professor</option>
                    <option value = 'Associate Professor'>Associate Professor</option>
                    <option value = 'Instructor'>Instructor</option>
                    <option value = 'Professor of the Practice'>Professor of the Practice</option>
                    <option value = 'Graduate Student'>Graduate Student</option>
                    <option value = 'Other'>Other</option>
                  </select>
                </div>
              </div>
            </div>
          </div>`;
}
const renderStudentFillout = function() {
  return `<div class="formDiv">
            <div class="field">
              <label class="label">Expected Graduation Date</label>
              <div class="control">
                <input id = 'year' class="input" type="text" placeholder="i.e. 2020" name='year'>
              </div>
            </div>
            <div class="field">
              <label class="label">Major</label>
              <form autocomplete="off">
              <div class="control, autocomplete" style="width:300px;">
                <input class="input" id='major' type="text" name='major' placeholder="i.e. Computer Science">
              </div>
            </div>
          </div>`;

}

function showDiv() {
  let select = document.getElementById("accountType").value;
  if(select == "Organization") {
    document.getElementById("addFillOut").innerHTML = renderOrganizationFillout();
    function autocomplete(inp, arr) {
      /*the autocomplete function takes two arguments,
      the text field element and an array of possible autocompleted values:*/
      var currentFocus;
      /*execute a function when someone writes in the text field:*/
      inp.addEventListener("input", function(e) {
          var a, b, i, val = this.value;
          /*close any already open lists of autocompleted values*/
          closeAllLists();
          if (!val) { return false;}
          currentFocus = -1;
          /*create a DIV element that will contain the items (values):*/
          a = document.createElement("DIV");
          a.setAttribute("id", this.id + "autocomplete-list");
          a.setAttribute("class", "autocomplete-items");
          /*append the DIV element as a child of the autocomplete container:*/
          this.parentNode.appendChild(a);
          /*for each item in the array...*/
          for (i = 0; i < arr.length; i++) {
            /*check if the item starts with the same letters as the text field value:*/
            if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
              /*create a DIV element for each matching element:*/
              b = document.createElement("DIV");
              /*make the matching letters bold:*/
              b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
              b.innerHTML += arr[i].substr(val.length);
              /*insert a input field that will hold the current array item's value:*/
              b.innerHTML += "<input id = 'myInput' type='hidden' value='" + arr[i] + "'>";
              /*execute a function when someone clicks on the item value (DIV element):*/
              b.addEventListener("click", function(e) {
                  /*insert the value for the autocomplete text field:*/
                  inp.value = this.getElementsByTagName("input")[0].value;
                  /*close the list of autocompleted values,
                  (or any other open lists of autocompleted values:*/
                  closeAllLists();
              });
              a.appendChild(b);
            }
          }
      });
    
    
      function closeAllLists(elmnt) {
        /*close all autocomplete lists in the document,
        except the one passed as an argument:*/
        var x = document.getElementsByClassName("autocomplete-items");
        for (var i = 0; i < x.length; i++) {
          if (elmnt != x[i] && elmnt != inp) {
            x[i].parentNode.removeChild(x[i]);
          }
        }
      }
      /*execute a function when someone clicks in the document:*/
      document.addEventListener("click", function (e) {
          closeAllLists(e.target);
      });
    }
    
    /*An array containing all the country names in the world:*/
    var countries = ["African, African American and Diaspora Studies", 
    "Air Force ROTC", "Allied Health", "American Studies", "Anesthesiology", 
    "Anthropology", "Applied Physical Sciences", "Archaeology", "Army ROTC", 
    "Art and Art History", "Asian Studies", "Biochemistry and Biophysics",
    "Biology", "Biomedical Engineering", "Biostatistics","Cell Biology and Physiology",
    "Chemistry", "Chinese", "City and Regional Planning", "Classics", "Communication",
    "Computer Science", "Dermatology", "Dramatic Art", "Economics", "English and Comparative Literature", 
    "Environmental Sciences and Engineering", "Epidemiology", "Exercise and Sport Science", 
    "Family Medicine", "French", "Genetics", "Geography", "Geological Sciences", 
    "Germanic and Slavic Languages and Literatures", "Global Business Center", "Health Behavior",
    "Health Policy and Management", "History", "Italian", "Linguistics", "Marine Sciences",
    "Maternal and Child Health", "Mathematics", "Medicine", "Microbiology and Immunology", "Military Science", 
    "Music", "Navy ROTC", "Neurology", "Nutrition", "Obstetrics and Gynecology", "Operations Research", "Ophthalmology", 
    "Orthopaedics", "Otolaryngology", "Pathology", "Pediatrics", "Pharmacology", "Philosophy", 
    "Physical Medicine & Rehabilitation", "Physics and Astronomy", "Political Science", 
    "Portuguese", "Psychiatry", "Psychology and Neuroscience", "Public Policy", "Religious Studies",
    "Romance Studies", "Slavic Languages and Literatures", "Social Medicine", "Sociology",
    "Spanish", "Statistics and Operations Research", "Surgery", "Women’s and Gender Studies"];
    
    /*initiate the autocomplete function on the "myInput" element, and pass along the countries array as possible autocomplete values:*/
    autocomplete(document.getElementById("myInput"), countries);
  } else if(select == "Student") {
    document.getElementById("addFillOut").innerHTML = renderStudentFillout();
    function autocomplete(inp, arr) {
      /*the autocomplete function takes two arguments,
      the text field element and an array of possible autocompleted values:*/
      var currentFocus;
      /*execute a function when someone writes in the text field:*/
      inp.addEventListener("input", function(e) {
          var a, b, i, val = this.value;
          /*close any already open lists of autocompleted values*/
          closeAllLists();
          if (!val) { return false;}
          currentFocus = -1;
          /*create a DIV element that will contain the items (values):*/
          a = document.createElement("DIV");
          a.setAttribute("id", this.id + "autocomplete-list");
          a.setAttribute("class", "autocomplete-items");
          /*append the DIV element as a child of the autocomplete container:*/
          this.parentNode.appendChild(a);
          /*for each item in the array...*/
          for (i = 0; i < arr.length; i++) {
            /*check if the item starts with the same letters as the text field value:*/
            if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
              /*create a DIV element for each matching element:*/
              b = document.createElement("DIV");
              /*make the matching letters bold:*/
              b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
              b.innerHTML += arr[i].substr(val.length);
              /*insert a input field that will hold the current array item's value:*/
              b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
              /*execute a function when someone clicks on the item value (DIV element):*/
              b.addEventListener("click", function(e) {
                  /*insert the value for the autocomplete text field:*/
                  inp.value = this.getElementsByTagName("input")[0].value;
                  /*close the list of autocompleted values,
                  (or any other open lists of autocompleted values:*/
                  closeAllLists();
              });
              a.appendChild(b);
            }
          }
      });
    
    
      function closeAllLists(elmnt) {
        /*close all autocomplete lists in the document,
        except the one passed as an argument:*/
        var x = document.getElementsByClassName("autocomplete-items");
        for (var i = 0; i < x.length; i++) {
          if (elmnt != x[i] && elmnt != inp) {
            x[i].parentNode.removeChild(x[i]);
          }
        }
      }
      /*execute a function when someone clicks in the document:*/
      document.addEventListener("click", function (e) {
          closeAllLists(e.target);
      });
    }
    
    /*An array containing all the country names in the world:*/
    var countries = ["African, African American, and Diaspora Studies Major, B.A.", 
    "American Studies Major, B.A.", "American Studies Major, B.A.–American Indian and Indigenous Studies Concentration",
    "American Studies Major, B.A.–Folklore Concentration", "American Studies Major, B.A.–Global American Studies Concentration", 
    "American Studies Major, B.A.–Southern Studies Concentration", "Anthropology Major, B.A.", "Archaeology Major, B.A.", "Art History Major, B.A.", 
    "Asian Studies Major, B.A.–Arab Cultures Concentration", "Asian Studies Major, B.A.–Chinese Concentration", 
    "Asian Studies Major, B.A.–Interdisciplinary Concentration", "Asian Studies Major, B.A.–Japanese Concentration",
    "Asian Studies Major, B.A.–Korean Studies Concentration", "Asian Studies Major, B.A.–South Asian Studies Concentration", "Biology Major, B.A.", 
    "Biology Major, B.S.–Quantitative Biology Track", "Biomedical and Health Sciences Engineering Major, B.S.", 
    "Biostatistics Major, B.S.P.H.", "Business Administration Major, B.S.B.A.", "Business Journalism Major, B.A.", 
    "Chemistry Major, B.A.", "Chemistry Major, B.S.", "Chemistry Major, B.S.–Biochemistry Track", "Chemistry Major, B.S.–Polymer Track", 
    "Classics Major, B.A.–Classical Archaeology", "Classics Major, B.A.–Classical Civilization", "Classics Major, B.A.–Greek, Latin, and Combined Greek and Latin", 
    "Clinical Laboratory Science Major, B.S.", "Communication Studies Major, B.A.", "Computer Science Major, B.A.", "Computer Science Major, B.S.", 
    "Contemporary European Studies Major, B.A.", "Dental Hygiene Major, B.S.", "Dramatic Art Major, B.A.", "Economics Major, B.A.", 
    "English and Comparative Literature Major, B.A.", "Environmental Health Sciences Major, B.S.P.H.", "Environmental Science, B.S.", 
    "Environmental Studies Major, B.A.", "Exercise and Sport Science Major, B.A.–Fitness Professional", "Exercise and Sport Science Major, B.A.–General", 
    "Exercise and Sport Science Major, B.A.–Sport Administration", "Geography Major, B.A.", "Geological Sciences Major, B.A.–Earth Science Concentration", 
    "Geological Sciences Major, B.S.–Earth Science Concentration", "Geological Sciences Major, B.S.–Environmental Geoscience Concentration", 
    "Germanic and Slavic Languages and Literatures Major, B.A.–Central European Studies Concentration", 
    "Germanic and Slavic Languages and Literatures Major, B.A.–German Literature and Culture Concentration", 
    "Germanic and Slavic Languages and Literatures Major, B.A.–German Media, Arts, and Culture Concentration", 
    "Germanic and Slavic Languages and Literatures Major, B.A.–Russian Language and Culture Concentration", 
    "Germanic and Slavic Languages and Literatures Major, B.A.–Slavic and East European Languages and Cultures Concentration", "Global Studies Major, B.A.",
    "Health Policy and Management Major, B.S.P.H.", "History Major, B.A.", "Information Science Major, B.S.", "Interdisciplinary Studies Major, B.A.", 
    "Interdisciplinary Studies Major, B.A.–Cultural Studies", "Latin American Studies Major, B.A.", "Linguistics Major, B.A.", 
    "Management and Society Major, B.A.", "Mathematics Major, B.A.", "Mathematics Major, B.S.", "Media and Journalism Major, B.A.", "Music Major, B.A.", 
    "Music Major, Bachelor of Music (B.Mus.), Neuroscience Major, B.S.", "Nursing Major, B.S.N.", "Nutrition Major, B.S.P.H.", "Peace, War, and Defense Major, B.A.", 
    "Philosophy Major, B.A.", "Physics Major, B.A.", "Physics Major, B.S.", "Political Science Major, B.A.", "Psychology Major, B.A.", "Psychology Major, B.S.", 
    "Public Policy Major, B.A.", "Radiologic Science Major, B.S.", "Religious Studies Major, B.A.", "Religious Studies Major, B.A.–Jewish Studies Concentration", 
    "Romance Languages Major, B.A.–French and Francophone Studies", "Romance Languages Major, B.A.–Hispanic Linguistics",
    "Romance Languages Major, B.A.–Hispanic Literatures and Cultures", "Romance Languages Major, B.A.–Italian", "Romance Languages Major, B.A.–Portuguese",
    "Sociology Major, B.A.", "Statistics and Analytics Major, B.S.", "Studio Art Major, B.A.", "Studio Art Major, Bachelor of Fine Arts (B.F.A)",
    "Studio Art Major, Bachelor of Fine Arts (B.F.A)–Art History Emphasis", "Women’s and Gender Studies Major, B.A."];
    
    /*initiate the autocomplete function on the "myInput" element, and pass along the countries array as possible autocomplete values:*/
    autocomplete(document.getElementById("myInput"), countries);
  } else {
    $(".formDiv").remove();
  }
}
