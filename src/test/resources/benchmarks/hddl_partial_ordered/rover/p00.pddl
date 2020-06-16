(define
	(problem pfile1)
	(:domain  rover_domain)
	(:objects
		waypoint0 - waypoint
		waypoint1 - waypoint
		waypoint2 - waypoint
		waypoint3 - waypoint
		colour - mode
		high_res - mode
		low_res - mode
		rover0store - store
		rover0 - rover
		camera0 - camera
		general - lander
;;		objective0 - objective
		objective1 - objective
	)
	(:htn
		:subtasks (and
		 (task0 (get_soil_data waypoint2))
		 (task1 (get_rock_data waypoint3))
		 (task2 (get_image_data objective1 high_res))
		)
		:ordering (;;and
			;;(task2 < task0)
			;;(task0 < task1)
		)
	)
	(:init
		(visible waypoint1 waypoint0)
		(visible waypoint0 waypoint1)
		(visible waypoint2 waypoint0)
		(visible waypoint0 waypoint2)
		(visible waypoint2 waypoint1)
		(visible waypoint1 waypoint2)
		(visible waypoint3 waypoint0)
		(visible waypoint0 waypoint3)
		(visible waypoint3 waypoint1)
		(visible waypoint1 waypoint3)
		(visible waypoint3 waypoint2)
		(visible waypoint2 waypoint3)
		(at_soil_sample waypoint0)
		(at_rock_sample waypoint1)
		(at_soil_sample waypoint2)
		(at_rock_sample waypoint2)
		(at_soil_sample waypoint3)
		(at_rock_sample waypoint3)
		(at_lander general waypoint0)
		(channel_free general)
		(at rover0 waypoint3)
		(available rover0)
		(store_of rover0store rover0)
		(empty rover0store)
		(equipped_for_soil_analysis rover0)
		(equipped_for_rock_analysis rover0)
		(equipped_for_imaging rover0)
		(can_traverse rover0 waypoint3 waypoint0)
		(can_traverse rover0 waypoint0 waypoint3)
		(can_traverse rover0 waypoint3 waypoint1)
		(can_traverse rover0 waypoint1 waypoint3)
		(can_traverse rover0 waypoint1 waypoint2)
		(can_traverse rover0 waypoint2 waypoint1)
		(on_board camera0 rover0)
		(calibration_target camera0 objective1)
		(supports camera0 colour)
		(supports camera0 high_res)
;;		(visible_from objective0 waypoint0)
;;		(visible_from objective0 waypoint1)
;;		(visible_from objective0 waypoint2)
;;		(visible_from objective0 waypoint3)
		(visible_from objective1 waypoint0)
		(visible_from objective1 waypoint1)
		(visible_from objective1 waypoint2)
		(visible_from objective1 waypoint3)
	)
)
