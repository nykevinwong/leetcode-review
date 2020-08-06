leetcodes = [];

  function loadJSON(callback) {   
    var xobj = new XMLHttpRequest();
    xobj.overrideMimeType("application/json");
    xobj.open('GET', 'leetcode.json', true); // Replace 'my_data' with the path to your file
    xobj.onreadystatechange = function () {
    if (xobj.readyState == 4 && xobj.status == "200") {
      // Required use of an anonymous callback as .open will NOT return a value but simply returns undefined in asynchronous mode
      callback(xobj.responseText);
    }
    };
    xobj.send();  
  }

  function init() {
  loadJSON(function(response) {
    // Parse JSON string into object
      var leetcodeData = JSON.parse(response);
      
      for(let i=0;i < leetcodeData.num_total; i++)
      {
        var item = leetcodeData.stat_status_pairs[i];
        var id =  item.stat.frontend_question_id;
        leetcodes[id+""]  = item.stat;
      }

      let lis = document.querySelectorAll("li");

      for(let i=0;i < lis.length; i++)
      {
          let li = lis[i];
          let num = i + 1;
          let liID = "li_"+ num;
          let codeID = "code_"+ num;
          let dataIDs = li.getAttribute("data-id").split("-");

          console.log(dataIDs);

          let firstLeetCodeItem = leetcodes[dataIDs[0]];
          let liAnchor = document.querySelector("#" + liID + " > a");
          let text = liAnchor.textContent;
          liAnchor.textContent = dataIDs[0] + ". " + firstLeetCodeItem.question__title_slug;
          if(text.length > 0) liAnchor.textContent+= " (" + text + ")";

          let codeAnchor = document.querySelector("#" + codeID + " > a");
          let problemUrl = "https://leetcode.com/problems/" + firstLeetCodeItem.question__title_slug;
          codeAnchor.textContent =  dataIDs[0] + ". " +  firstLeetCodeItem.question__title_slug;
          codeAnchor.href = problemUrl;

          for(let j=0; j < dataIDs.length;j++)
          {
            let leetcode = leetcodes[dataIDs[j]];
            let problemUrl = "https://leetcode.com/problems/" + leetcode.question__title_slug;
          }
      }

  });

  }

  init();
