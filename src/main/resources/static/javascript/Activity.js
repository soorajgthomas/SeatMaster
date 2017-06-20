var firstSeatLabel = 1;
		
			$(document).ready(function() {
				var $cart = $('#selected-seats'),
					$counter = $('#counter'),
					$total = $('#total'),
					sc = $('#seat-map').seatCharts({
					map: ['x___x',
					      'l___l',
					      '_c___c_',
					      'dd__dd',
						'_c___c_',
						'dd__dd',
						'w___w',
						'eee_eee',
						'eee_eee',
						'x___x',
						'eee_eee',
						'eee_eee',
						'eee_eee',
						'eee_eee',
						'eee_eee',
						
						'w___w',
						'eee_eee',
						'eee_eee',
						'eee_eee',
						'eee_eee',
						'eee_eee',
						'eee_eee',
						'eee_eee',
						'eee_eee',
						'eee_eee',
						'eee_eee',
						'eee_eee',
						'eee_eee',
						'eee_eee',
						'eee_eee',
						'l___l',
						
					],
					seats: {
						f: {
							price   : 100,
							classes : 'first-class', //your custom CSS class
							category: 'First Class'
						},
						e: {
							price   : 40,
							classes : 'economy-class', //your custom CSS class
							category: 'Economy Class'
						},
						a: {
							price   : 200,
							classes : 'first-class middle-seat', //your custom CSS class
							category: 'First-Class'
						},
						c: {
							price   : 90,
							classes : 'first-class prime-seat', //your custom CSS class
							category: 'First Class '
						},
						d: {
							price   : 70,
							classes : 'first-class normal-seat', //your custom CSS class
							category: 'First Class'
						},
						
						
						
					
					},
					naming : {
						top : true,
						getLabel : function (character, row, column) {
							return firstSeatLabel++;
						},
					},
					/*legend : {
						node : $('#legend'),
					    items : [
							[ 'f', 'available',   'First Class' ],
							[ 'a', 'available',   'First Middle Class' ],
							[ 'e', 'available',   'Economy Class'],
							[ 'g', 'unavailable', 'Already Booked']
					    ]					
					},*/
					click: function () {
					     
						if (this.status() == 'available') {
							//let's create a new <li> which we'll add to the cart items

							$('<li>'+this.data().category+' Seat # '+this.settings.label+': <b>$'+this.data().price+'</b> <a href="#" class="cancel-cart-item"><img src="./images/delete.png"></a></li>')
								.attr('id', 'cart-item-'+this.settings.id)
								.data('seatId', this.settings.id)
								.appendTo($cart);
							
							/*
							 * Lets update the counter and total
							 *
							 * .find function will not find the current seat, because it will change its status only after return
							 * 'selected'. This is why we have to add 1 to the length and the current seat price to the total.
							 */
							$counter.text(sc.find('selected').length+1);
							$total.text(recalculateTotal(sc)+this.data().price + 80);
							
							return 'selected';
						} else if (this.status() == 'selected') {
							//update the counter
							$counter.text(sc.find('selected').length-1);
							//and total
							$total.text(recalculateTotal(sc)-this.data().price + 80);
						
							//remove the item from our cart
							$('#cart-item-'+this.settings.id).remove();
						
							//seat has been vacated
							return 'available';
						} else if (this.status() == 'unavailable') {
							//seat has been already booked
							return 'unavailable';
						} else {
							return this.style();
						}
					}
				});

				//this will handle "[cancel]" link clicks
				$('#selected-seats').on('click', '.cancel-cart-item', function () {
					//let's just trigger Click event on the appropriate seat, so we don't have to repeat the logic here
					sc.get($(this).parents('li:first').data('seatId')).click();
				});

				//let's pretend some seats have already been booked
				sc.get(['1_2', '4_1', '7_1', '7_2']).status('unavailable');
		
		});

		function recalculateTotal(sc) {
			var total = 0;
		
			//basically find every selected seat and sum its price
			sc.find('selected').each(function () {
				total += this.data().price;
			});
			
			return total;
		}
