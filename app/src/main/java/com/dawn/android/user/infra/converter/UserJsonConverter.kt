package com.dawn.android.user.infra.converter

import com.dawn.android.user.domain.model.Contact
import com.dawn.android.user.domain.model.Creator
import com.dawn.android.user.domain.model.CreatorId
import com.dawn.android.user.domain.model.Job
import com.dawn.android.user.domain.model.JobId
import com.dawn.android.user.infra.api.json.ContactJson
import com.dawn.android.user.infra.api.json.JobJson
import com.dawn.android.user.infra.api.json.MaskedUserJson
import java.time.Instant

object UserJsonConverter {
    fun convertToDomainModel(json: JobJson): Job {
        return Job(
            id = JobId(json.id),
            jobName = json.jobName,
            dateOfFirstJob = Instant.parse(json.dateOfFirstJob),
        )
    }

    fun convertToDomainModel(json: MaskedUserJson): Creator {
        return Creator(
            id = CreatorId(json.creator.id),
            imageUrl = json.imageUrl,
            displayName = json.creator.realName,
            job = convertToDomainModel(json.creator.job),
        )
    }

    fun convertToDomainModel(json: ContactJson): Contact {
        return Contact(
            hpLink = json.hpLink,
            instagramLink = json.instagramLink,
            twitterLink = json.twitterLink,
            facebookLink = json.facebookLink,
            tiktokLink = json.tiktokLink,
            biography = json.biography ?: "",
        )
    }
}
