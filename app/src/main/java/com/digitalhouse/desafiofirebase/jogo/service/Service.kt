package com.digitalhouse.desafiofirebase.jogo.service

import com.google.firebase.firestore.FirebaseFirestore


var db = FirebaseFirestore.getInstance()
var cr = db.collection("jogos")