function afficheElement (elem)
{
    let messageElement = "";
    
    messageElement += `ELEMENT : ${elem.nodeName} ( ${elem.children.length} children et ${elem.childNodes.length} childNodes )`;
    messageElement += "\n\t Childnodes : ";
    
    for (let noeudPresent of elem.childNodes)
    {
        messageElement += noeudPresent.nodeName + " ";
    }

    console.log(messageElement);

    for (let enfant of elem.children)
    {
        afficheElement(enfant);
    }
}

function changeStyle (elem)
{
    for (let elementLu of elem)
    {
        elementLu.style.fontStyle = "italic";
    }
}